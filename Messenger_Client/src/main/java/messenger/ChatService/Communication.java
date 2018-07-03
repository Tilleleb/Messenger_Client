package messenger.ChatService;

import java.util.List;

public interface Communication {
	
	/**
	 * sends message
	 * @param txt text of the message
	 * @param user_id user who send the message
	 * @param chat_id chat-id of the chat which the message is send to
	 * @return true: message successful send; false: message couldn't send
	 */
	public boolean sendMessage(String txt, Long userId, Long chatId);
	
	/**
	 * @param chat_id id of the chat
	 * @return String-Array with all Messages belonging to the chat
	 */
	public List<String> recieveMessage(Long chatId);

}
