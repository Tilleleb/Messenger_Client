package messenger.Interface;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import messenger.ChatService.ChatValidation;
import messenger.ChatServiceImpl.ChatValidationImpl;

/**
 * Unit test for simple App.
 */
public class ChatValidationTest {

	ChatValidation service;
	
    @Before
    public void initialize() {
    	service =  new ChatValidationImpl();
     }

	@Test
	public void testIsZero() {
		testForFalse(0L);
	}
	
	@Test
	public void testChatExist() {
		testForTrue(1L);
	}
	
	@Test
	public void testChatDontExist() {
		testForFalse(99L);
	}
		
	public void testForTrue(Long testValue) {
		Assert.assertTrue(service.checkIfChatExists(testValue));
	}
	
	public void testForFalse(Long testValue) {
		Assert.assertFalse(service.checkIfChatExists(testValue));
	}
}
