package messenger.ChatService;

public interface ChatValidation {

	/**
	 * checks if a chat with the given id exists
	 * @param chat_id unique id for a chat
	 * @return true: chat exists; false: chat doesn't exist
	 */
	public boolean checkIfChatExists(Long chatId);
	

}
