package messenger.DbService;

import java.util.List;
import messenger.Domain.ChatConversation;
import messenger.Domain.GroupConversation;
import messenger.Domain.UserChat;

public interface ConversationService {

	/**
	 * Generische Methode, um die übergebene Entität als Eintrag in der Datenbank
	 * zu erzeugen.
	 * 
	 * @param entity
	 *            generische Entität, welche in die Datenbank persistiert werden
	 *            soll
	 */
	public <T> void persistObject(T entity);

	/**
	 * Generische Methode, um den Eintrag der übergebenen Entität in der
	 * Datenbank zu aktualisieren.
	 * 
	 * @param entity
	 *            generische Entität, dessen Eintrag in der Datenbank
	 *            aktualisiert werden soll
	 */
	public <T> void mergeObject(T entity);

	/**
	 * Generische Methode, um den Eintrag der übergebenen Entität aus der
	 * Datenbank zu entfernen.
	 * 
	 * @param entity
	 *            generische Entität, dessen Eintrag aus der Datenbank entfernt
	 *            werden soll
	 */
	public <T> void removeObject(T entity);
	
	public ChatConversation getChatById(Long chatId);
	
	public GroupConversation getGroupChatById(Long chatId);
	
	public UserChat getUserChatById(Long chatId, Long userId);

	public List<UserChat> getUserChatsById(Long chatId);
	
	public List<Long> getAllConversations(Long userId);
}
