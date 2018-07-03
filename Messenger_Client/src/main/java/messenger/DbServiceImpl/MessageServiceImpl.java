package messenger.DbServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import messenger.DbService.MessageService;
import messenger.Domain.Message;

@Service
@Scope("singleton")
public class MessageServiceImpl implements MessageService {

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

	public List<String> receiveMessage(Long chatId) {
		TypedQuery<Message> query = em.createQuery("SELECT message FROM Message message WHERE message.chat.chatId = :chatId", Message.class);
		query.setParameter("chatId", chatId);
		List<Message> messageList = query.getResultList();
		List<String> messages = new ArrayList<String>();
		for( Message message: messageList )
		{
			messages.add(message.getSender().getUsername() + ";" + message.getTimestamp() + ";" + message.getText());
		}
        return messages;
	}
}