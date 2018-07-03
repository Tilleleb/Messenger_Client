package messenger.ChatServiceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.ChatService.Communication;
import messenger.DbService.ConversationService;
import messenger.DbService.MessageService;
import messenger.DbService.UserService;
import messenger.Domain.ChatConversation;
import messenger.Domain.Message;
import messenger.Domain.User;

@Service
@Scope("singleton")
public class CommunicationImpl implements Communication, Serializable {
	
	@Autowired
	private UserService userDbService;
	
	@Autowired
	private ConversationService conversationDbService;
	
	@Autowired
	private MessageService messageDbService;

	@Transactional
	public boolean sendMessage(String txt, Long userId, Long chatId) {
		txt = txt.replaceAll(";", " ");
		if (txt == null || txt.length() < 1) return false;
		ChatConversation chatConversation = conversationDbService.getChatById(chatId);
		User userSender = userDbService.getUserById(userId);
		if (chatConversation == null || userSender == null) return false;
		Message newMessage = new Message();
		newMessage.setChat(chatConversation);
		newMessage.setSender(userSender);
		messageDbService.persistObject(newMessage);
		return true;
	}

	@Transactional
	public List<String> recieveMessage(Long chatId) {
		return messageDbService.receiveMessage(chatId);
	}

}
