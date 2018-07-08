package messenger.Gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import messenger.Domain.User;
import messenger.ServiceAdapter.GetUserAdapter;
import messenger.ServiceAdapter.UserManagementAdapter;

import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope("session")
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
    private UserManagementAdapter userManagement;
    
	@Autowired
    private GetUserAdapter getUser;
    
    private List<User> userList = new ArrayList<User>();
    
    private String username;
    
    private Long userId;
    
    private boolean isUserSet =false;
    
    @PostConstruct
    public void init() {
    	userList = Arrays.asList(userManagement.getAllUsers());
    }

	public UserManagementAdapter getUserManagement() {
		return userManagement;
	}

	public void setUserManagement(UserManagementAdapter userManagement) {
		this.userManagement = userManagement;
	}

	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean getIsUserSet() {
		return isUserSet;
	}

	public void setIsUserSet(boolean isUserSet) {
		this.isUserSet = isUserSet;
	}
    
    public String save(){
    	//userId = getUser.getUser(username);
    	//isUserSet = true;
    	return "success";
    }
    
    public String deleteUser(){
    	//userId = getUserId().getUser(username);
    	//userManagement.deleteUser(userId);
    	this.init();
    	this.logout();
    	isUserSet = false;
    	username = "";
    	userId = null;
    	return "successDelete";
    }
    
    public String logout(){
    	isUserSet = false;
    	username = "";
    	userId = null;
    	return "chooseUser?faces-redirect=true";
    }
    
    
}
