package messenger.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserChat implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
    
    @Id
    @ManyToOne
    @JoinColumn(name="CHAT_ID")
    private ChatConversation chat;
    
    @Column(name = "ADMIN")
    private boolean admin;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ChatConversation getChat() {
		return chat;
	}

	public void setChat(ChatConversation chat) {
		this.chat = chat;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


}
