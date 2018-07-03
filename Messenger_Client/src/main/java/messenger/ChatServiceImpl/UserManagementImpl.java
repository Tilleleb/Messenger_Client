package messenger.ChatServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

import messenger.ChatService.UserManagement;
import messenger.DbService.UserService;
import messenger.Domain.User;


@Service
@Scope("singleton")
public class UserManagementImpl implements UserManagement, Serializable {
	 
    @Autowired
    private UserService userDbService;
  

    @Transactional
	public int addUser(String username, String password) {
    	if (isOkUsername(username) && isOkPassword(password)) {
    		if (userDbService.getUserByName(username) == null) {
    			User newuser = new User();
    			newuser.setUsername(username);
    			newuser.setPassword(password);
    			userDbService.persistObject(newuser);
    			return 0;
    		} else return 1;
    	}
		return 2;
	}
    
    @Transactional
	public boolean deleteUser(Long userId) {
		User user = userDbService.getUserById(userId);
		if (user == null) {
			return false;
		} 
		userDbService.removeObject(user);
		return true;	
	}

    @Transactional
	public boolean updateUser(Long userId, String username, String password) {
		User user = userDbService.getUserById(userId);
		if (isOkUsername(username) && isOkPassword(password) && user != null) {
			user.setPassword(password);
			user.setUsername(username);
			userDbService.mergeObject(user);
			return true;
		}
		return false;
	}

    @Transactional
	public int loginUser(String username, String password) {
	//	if (isOkUsername(username) && isOkPassword(password)) {
	//		return userservice.loginUser(username, password);
	//	}
		return 0;
	}

	@Transactional
	public List<String> getAllUsers() {
		return userDbService.getAllUsers();
	}
	
	
	private boolean isOkUsername(String username) {
		if (username == null || username.length() < 1 || username.length() > 20) {
    		return false;
    	}
		if (username.contains(";")) return false;
		return true;
	}
	
	private boolean isOkPassword(String password) {
		if (password == null || password.length() < 1 || password.length() > 20) {
    		return false;
    	}
		if (password.contains(";")) return false;
		return true;
	}

}
