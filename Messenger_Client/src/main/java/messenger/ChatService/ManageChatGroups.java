package messenger.ChatService;

import java.util.List;

public interface ManageChatGroups {
	
	/**
	 * adds a new group conversation
	 * @param userId of the user who create the chat
	 * @param name of the conversation
	 * @param picture adds a picture to the conversation
	 * @return true: Conversation was added
	 */
	public boolean addConversation(Long userId);	
	
	/**
	 * adds a new group conversation
	 * @param userId of the user who create the chat
	 * @param name of the conversation
	 * @param picture adds a picture to the conversation
	 * @return true: Conversation was added
	 */
	public boolean addGroupConversation(Long userId, String name, byte[] picture);
	
	/**
	 * delete a conversation
	 * @param chat_id id of the conversation
	 * @return true: id conversation was deleted
	 */
	public boolean deleteConveration(Long chatId);
	
	
	/**
	 * updates a conversation
	 * @param chat_id id to find the conversation the should be updated
	 * @param name new name for the conversation
	 * @param picture new picture for the conversation
	 * @return true: conversation was updated
	 */
	public boolean updateConversation(Long chatId, String name, byte[] picture);
	
	/**
	 * @param user_id the user_id of the user who wants to view his chats
	 * @return returns a two dimensional array with all the informations of conversations belonging to a user or return null if no chats found
	 */
	public List<Long> getAllConversations(Long userId);
	
	/**
	 * adds a user to the conversation
	 * @param chat_id id of the conversation the user should be added to
	 * @param user_id id of the user that should be added
	 * @return true: the user was added
	 */
	public boolean addUserToConversation(Long chatId, Long userId);
	
	/**
	 * delete a user from a conversation
	 * @param chat_id id of the conversation the user should be deleted from
	 * @param user_id id of the user that should be deleted
	 * @return true:  the user was deleted
	 */
	public boolean deleteUserFromConversation(Long chatId, Long userId);
	
	/**
	 * grant admin rigths to a user of a conversation
	 * @param chat_id id of the conversation the user gets admin rights for
	 * @param user_id id of the user that gets admin rights
	 * @return true: admin right where correctly added
	 */
	public boolean grantAdminPermission(Long chatId, Long userId);
	
	/**
	 * revoke admin rigths from a user of a conversation
	 * @param chat_id id of the conversation the user gets his admin rights revoked
	 * @param user_id id of the user that gets his admin rights revoked
	 * @return true: admin right where correctly revoked
	 */
	public boolean revokeAdminPermission(Long chatId, Long userId);
	
	

}
