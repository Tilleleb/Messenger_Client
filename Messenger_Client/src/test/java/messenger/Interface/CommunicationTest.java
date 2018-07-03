package messenger.Interface;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import messenger.ChatService.Communication;
import messenger.ChatServiceImpl.CommunicationImpl;

public class CommunicationTest {

	Communication service;
	
    @Before
    public void initialize() {
    	service = new CommunicationImpl();
     }

	
	// Tests for send message
	// --------------------------------------------------------------
	@Test
	public void testForAllOkSend() {
		// 1. Arrange
		String text = "text";
		Long user = 1L;
		Long chat = 1L;

		// 2. Act
		boolean bool = service.sendMessage(text, user, chat);

		// 3. Assert
		Assert.assertTrue(bool);
	}
	
	@Test
	public void testForChatNotOkSend() {
		Assert.assertFalse(service.sendMessage("text", 1L, -1L));
	}
	
	@Test
	public void testForUserNotOkSend() {
		Assert.assertFalse(service.sendMessage("text", -1L, 1L));
	}
	
	@Test
	public void testForTextEmptySend() {
		Assert.assertFalse(service.sendMessage("", 1L, 1L));
	}
	
	
	// Tests for receive message
	// --------------------------------------------------------------
	@Test
	public void testForAllOkReceive() {
		Assert.assertNotNull(service.recieveMessage(1L));
	}
	
	@Test
	public void testForUserNotOkReceive() {
		Assert.assertNull(service.recieveMessage(0L));
	}
}
