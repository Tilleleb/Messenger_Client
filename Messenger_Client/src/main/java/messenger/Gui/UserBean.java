package messenger.Gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

import messenger.ChatService.GetUser;
import messenger.ChatService.UserManagement;
import messenger.ChatServiceImpl.UserManagementImpl;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserBean implements Serializable{

	@Autowired
    private UserManagement userManagement;
    
	@Autowired
    private GetUser getUser;
    
    private List<String> userList = new ArrayList<String>();
    
    private String username;
    
    private Long userId;
    
    private boolean isUserSet =false;
    
    @PostConstruct
    public void init() {
    	userList = userManagement.getAllUsers();
    }

	public UserManagement getUserManagement() {
		return userManagement;
	}

	public void setUserManagement(UserManagementImpl userManagement) {
		this.userManagement = userManagement;
	}

	
	public List<String> getUserList() {
		return userList;
	}

	public void setUserList(List<String> userList) {
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
    	userId = getUser.getUser(username);
    	isUserSet = true;
    	return "success";
    }
    
    public String deleteUser(){
    	userId = getUser.getUser(username);
    	userManagement.deleteUser(userId);
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
