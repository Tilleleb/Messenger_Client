package messenger.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="chatId", referencedColumnName="CHAT_ID")
public class GroupConversation extends ChatConversation {
	
    @Id
    @Column(name = "CHAT_ID")
    private Long chatId;
    
	@Column(name = "NAME")
	private String name;

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
