package messenger.ChatServiceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.ChatService.ManageChatGroups;
import messenger.DbService.ConversationService;
import messenger.DbService.UserService;
import messenger.Domain.ChatConversation;
import messenger.Domain.GroupConversation;
import messenger.Domain.User;
import messenger.Domain.UserChat;

@Service
@Scope("singleton")
public class ManageChatGroupsImpl implements ManageChatGroups, Serializable {

	@Autowired
	private ConversationService conversationDbService;

	@Autowired
	private UserService userDbService;

	@Transactional
	public boolean addConversation(Long userId) {
		User user = userDbService.getUserById(userId);
		if (user == null)
			return false;
		ChatConversation newChatConversation = new ChatConversation();
		UserChat newUserChat = new UserChat();
		newUserChat.setChat(newChatConversation);
		newUserChat.setUser(user);
		newUserChat.setAdmin(true);
		conversationDbService.persistObject(newChatConversation);
		conversationDbService.persistObject(newUserChat);
		return true;
	}

	@Transactional
	public boolean addGroupConversation(Long userId, String name, byte[] picture) {
		if (name == null) name = "NoName";
		User user = userDbService.getUserById(userId);
		if (user == null)
			return false;
		ChatConversation newChatConversation = new ChatConversation();
		UserChat newUserChat = new UserChat();
		newUserChat.setChat(newChatConversation);
		newUserChat.setUser(user);
		newUserChat.setAdmin(true);
		GroupConversation newGroupConversation = new GroupConversation();
		newGroupConversation.setChatId(newChatConversation.getChatId());
		newGroupConversation.setName(name);
		conversationDbService.persistObject(newChatConversation);
		conversationDbService.persistObject(newUserChat);
		conversationDbService.persistObject(newGroupConversation);
		return true;
	}

	@Transactional
	public boolean deleteConveration(Long chatId) {
		ChatConversation chatConversation = conversationDbService.getChatById(chatId);
		List<UserChat> userChatList = conversationDbService.getUserChatsById(chatId);
		GroupConversation groupConversation = conversationDbService.getGroupChatById(chatId);
		if (chatConversation == null) return false;
		if (groupConversation != null) conversationDbService.removeObject(groupConversation);
		for (UserChat userChat : userChatList) conversationDbService.removeObject(userChat);
		conversationDbService.removeObject(chatConversation);
		return true;
	}

	@Transactional
	public boolean updateConversation(Long chatId, String name, byte[] picture) {
		GroupConversation groupConversation = conversationDbService.getGroupChatById(chatId);
		groupConversation.setName(name);
		conversationDbService.mergeObject(groupConversation);
		return true;
	}

	public List<Long> getAllConversations(Long userId) {
		return conversationDbService.getAllConversations(userId);
	}

	@Transactional
	public boolean addUserToConversation(Long chatId, Long userId) {
		ChatConversation chatConversation = conversationDbService.getChatById(chatId);
		if (chatConversation == null) return false;
		User user = userDbService.getUserById(userId);
		if (user == null) return false;
		UserChat newUserChat = new UserChat();
		newUserChat.setChat(chatConversation);
		newUserChat.setUser(user);
		conversationDbService.persistObject(newUserChat);
		return true;
	}

	@Transactional
	public boolean deleteUserFromConversation(Long chatId, Long userId) {
		// TODO: Gucken obs der letzt user ist und dann den chat mitlöschen oder exception
		UserChat userChat = conversationDbService.getUserChatById(chatId, userId);
		if (userChat == null) return false;
		conversationDbService.removeObject(userChat);
		return true;
	}

	@Transactional
	public boolean grantAdminPermission(Long chatId, Long userId) {
		UserChat userChat = conversationDbService.getUserChatById(chatId, userId);
		if (userChat == null) return false;
		userChat.setAdmin(true);
		conversationDbService.mergeObject(userChat);
		return true;
	}

	@Transactional
	public boolean revokeAdminPermission(Long chatId, Long userId) {
		// TODO: Gucken obs der letzte Admin war... Der letzte Admin darf nicht gelöscht werden
		UserChat userChat = conversationDbService.getUserChatById(chatId, userId);
		if (userChat == null) return false;
		userChat.setAdmin(false);
		conversationDbService.mergeObject(userChat);
		return true;
	}

}
