package messenger.DbServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import messenger.DbService.ConversationService;
import messenger.Domain.ChatConversation;
import messenger.Domain.GroupConversation;
import messenger.Domain.UserChat;

@Service
@Scope("singleton")
public class ConversationServiceImpl implements ConversationService{

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}
	
	public <T> void persistObject(T entity) {
		em.persist(entity);
	}

	public <T> void removeObject(T entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public <T> void mergeObject(T entity) {
		em.merge(entity);
	}

	public ChatConversation getChatById(Long chatId) {
		TypedQuery<ChatConversation> query = em.createQuery("SELECT chat FROM ChatConversation chat WHERE chat.chatId = :chatId", ChatConversation.class);
		query.setParameter("chatId", chatId);
		 try{
			 	return query.getSingleResult();
			 } catch (NoResultException nre) {
			    return null;
			 }
	}
	
	public List<UserChat> getUserChatsById(Long chatId) {
		TypedQuery<UserChat> query = em.createQuery("SELECT chat FROM UserChat chat WHERE chat.chatId = :chatId", UserChat.class);
		query.setParameter("chatId", chatId);
		 try{
			 	return query.getResultList();
			 } catch (NoResultException nre) {
			    return null;
			 }
	}


	public GroupConversation getGroupChatById(Long chatId) {
		TypedQuery<GroupConversation> query = em.createQuery("SELECT chat FROM GroupConversation chat WHERE chat.chatId = :chatId", GroupConversation.class);
		query.setParameter("chatId", chatId);
		 try{
			 	return query.getSingleResult();
			 } catch (NoResultException nre) {
			    return null;
			 }
	}

	public UserChat getUserChatById(Long chatId, Long userId) {
		TypedQuery<UserChat> query = em.createQuery("SELECT userChat FROM UserChat userChat WHERE chat.chat.chatId = :chatId AND chat.User.userId = :userId", UserChat.class);
		query.setParameter("chatId", chatId);
		query.setParameter("userId", userId);
		 try{
			 	return query.getSingleResult();
			 } catch (NoResultException nre) {
			    return null;
			 }
	}

	public List<Long> getAllConversations(Long userId) {
		TypedQuery<UserChat> query = em.createQuery("SELECT userChat FROM UserChat userChat WHERE userChat.user.userId = :userId", UserChat.class);
		query.setParameter("userId", userId);
		List<UserChat> userChatList = query.getResultList();
		// TODO: leere liste: null oder leere liste zurück?
		//if (userChatList.isEmpty()) return null;
		List<Long> allConversations = new ArrayList<Long>();
		for( UserChat userChat: userChatList )
		{
			allConversations.add(userChat.getChat().getChatId());
		}
        return allConversations;
	}
	

}