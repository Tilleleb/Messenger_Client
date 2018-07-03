package messenger.ChatService;

import java.util.List;

public interface UserManagement {
	
	/**
	 * add a new user to the chat system
	 * @param username name of the new user 
	 * @param password password of the new user
	 * @return 0: added successfully<br>
	 * 1: user already exists<br>
	 * 2: other error while adding
	 */
	public int addUser(String username, String password);
	
	/**
	 * delete an user from the chat system
	 * @param userid unique id of an user
	 * @return true: user deleted successfully<br>
	 * false: error while deleting
	 */
	public boolean deleteUser(Long userId);
	
	/**
	 * update user data
	 * @param userid unique id of an user
	 * @param username new username for the user
	 * @param password new password for the user
	 * @return true: update successful<br>
	 * false: error while updating
	 */
	public boolean updateUser(Long userId, String username, String password);
	
	/**
	 * checks login credentials
	 * @param username name of an user
	 * @param password password of the user
	 * @return id of the user<br>
	 * 0 when credentials not found
	 */
	public int loginUser(String username, String password);
	
	public List<String> getAllUsers();
	
}
