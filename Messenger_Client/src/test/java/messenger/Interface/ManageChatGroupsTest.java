package messenger.Interface;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import messenger.ChatService.ManageChatGroups;
import messenger.ChatServiceImpl.ManageChatGroupsImpl;

public class ManageChatGroupsTest {

	ManageChatGroups service;
	
    @Before
    public void initialize() {
    	service = new ManageChatGroupsImpl();
     }


	//Test addConversation
	//public boolean addConversation(String name, byte[] picture)

	@Test
	public void testOkAddConversation() {
		byte[] byteArray = new byte[1];
		byteArray[0] = 1;
//???		Assert.assertTrue(service.addConversation("chatName", byteArray));
	}
	
	@Test
	public void testWrongSignConversation() {
		byte[] byteArray = new byte[1];
		byteArray[0] = 1;
//???		Assert.assertFalse(service.addConversation("chatName&%", byteArray));
	}
	
	@Test
	public void testWrongPictureConversation() {
		byte[] byteArray = new byte[1];
		byteArray = null;
//???		Assert.assertFalse(service.addConversation("chatName", byteArray));
	}
	
	// Test deleteConversation
	//public boolean deleteConveration(int chat_id)
	
	@Test
	public void testOkDeleteConversation() {
		Assert.assertTrue(service.deleteConveration(1L));
	}
	
	@Test
	public void testDontExistDeleteConversation() {
		Assert.assertFalse(service.deleteConveration(0L));
	}

	// Test Update Conversation
	//public boolean updateConversation(int chat_id, String name, byte[] picture)
	

	@Test
	public void testOkUpdateConversation() {
		byte[] byteArray = new byte[1];
		byteArray[0] = 1;
		Assert.assertTrue(service.updateConversation(1L,"chatName", byteArray));
	}
	
	@Test
	public void testWrongSignUpdateConversation() {
		byte[] byteArray = new byte[1];
		byteArray[0] = 1;
		Assert.assertFalse(service.updateConversation(1L,"chatName&%", byteArray));
	}
	
	@Test
	public void testWrongPictureUpdateConversation() {
		byte[] byteArray = new byte[1];
		byteArray = null;
		Assert.assertFalse(service.updateConversation(1L,"chatName", byteArray));
	}
	
	@Test
	public void testWrongChatUpdateConversation() {
		byte[] byteArray = new byte[1];
		byteArray = null;
		Assert.assertFalse(service.updateConversation(0L,"chatName", byteArray));
	}

	// Test getConversations
	//public String[][] getAllConversations(int user_id)
	
	@Test
	public void testOkGetAllConversations() {
		Assert.assertNotNull(service.getAllConversations(1L));
	}
	
	@Test
	public void testWrongUserIDGetAllConversations() {
		Assert.assertNull(service.getAllConversations(0L));
	}
	
	// Test addUser
	//public boolean addUserToConversation(int chat_id, int user_id) 
	@Test
	public void testOkAddUser() {
		Assert.assertTrue(service.addUserToConversation(1L,2L));
	}
	
	@Test
	public void testWrongChatAddUser() {
		Assert.assertFalse(service.addUserToConversation(0L,2L));
	}
	
	@Test
	public void testWrongUserAddUser() {
		Assert.assertFalse(service.addUserToConversation(1L,0L));
	}

	// test deleteuser from chat
	//public boolean deleteUserFromConversation(int chat_id, int user_id) ,
	@Test
	public void testOkDeleteUser() {
		Assert.assertTrue(service.deleteUserFromConversation(1L,2L));
	}
	
	@Test
	public void testWrongChatDeleteUser() {
		Assert.assertFalse(service.deleteUserFromConversation(0L,2L));
	}
	
	@Test
	public void testWrongUserDeleteUser() {
		Assert.assertFalse(service.deleteUserFromConversation(1L,0L));
	}

	//public boolean grantAdminPermission(int chat_id, int user_id) 
	@Test
	public void testOkAdminPer() {
		Assert.assertTrue(service.grantAdminPermission(1L,2L));
	}
	
	@Test
	public void testWrongChatAdminPer() {
		Assert.assertFalse(service.grantAdminPermission(0L,2L));
	}
	
	@Test
	public void testWrongUserAdminPer() {
		Assert.assertFalse(service.grantAdminPermission(1L,0L));
	}

	//public boolean revokeAdminPermission(int chat_id, int user_id)
	@Test
	public void testOkAdminRev() {
		Assert.assertTrue(service.revokeAdminPermission(1L,2L));
	}
	
	@Test
	public void testWrongChatAdminRev() {
		Assert.assertFalse(service.revokeAdminPermission(0L,2L));
	}
	
	@Test
	public void testWrongUserAdminRev() {
		Assert.assertFalse(service.revokeAdminPermission(1L,0L));
	}
	
	
	
}
