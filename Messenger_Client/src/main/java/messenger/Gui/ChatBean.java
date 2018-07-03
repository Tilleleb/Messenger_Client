package messenger.Gui;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import messenger.ChatService.Communication;
import messenger.ChatService.ManageChatGroups;


@ManagedBean
@SessionScoped
public class ChatBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//@ManagedProperty("#{userBean}")
	@Autowired
	private UserBean userBean;
    
//	@ManagedProperty("#{chatBeanList}")
//    private ChatListBean chatBeanList;

	@Autowired
	private ManageChatGroups manageChatGroups;
	
	@Autowired
    private Communication communication;
    
    private String[][] arrayMessages;
    
    private String message;
    
    private Long chatId;

	private List<Long> chatList = new ArrayList<Long>();
    
    private List<String> messageList = new ArrayList<String>();
    
    @PostConstruct
    private void init() {
    	//chatList = manageChatGroups.getAllConversations(userBean.getUserId());
    }
    
    public ManageChatGroups getManageChatGroups() {
		return manageChatGroups;
	}

	public void setManageChatGroups(ManageChatGroups manageChatGroups) {
		this.manageChatGroups = manageChatGroups;
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public List<Long> getChatList() {
		return chatList;
	}

	public void setChatList(List<Long> chatList) {
		this.chatList = chatList;
	}

	public UserBean getUserBean() {
		return userBean;
	}


	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}


	public Communication getCommunication() {
		return communication;
	}


	public void setCommunication(Communication communication) {
		this.communication = communication;
	}


	public String[][] getArrayMessages() {
		return arrayMessages;
	}


	public void setArrayMessages(String[][] arrayMessages) {
		this.arrayMessages = arrayMessages;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<String> getMessageList() {
		return messageList;
	}


	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}
    
	
	public void sendMessage(){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		Date date = new Date();
		
		messageList.add(userBean.getUsername() + " - " + dateFormat.format(date) + " - " + message);
		this.message = "";
	}
	
	public List<Long> getAllConversations(Long userId) {
		return manageChatGroups.getAllConversations(userId);
	}

    public String showChat() {
        return "success";
    }
}
