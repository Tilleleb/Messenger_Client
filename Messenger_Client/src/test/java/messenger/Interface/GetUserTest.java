package messenger.Interface;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import messenger.ChatService.GetUser;
import messenger.ChatServiceImpl.GetUserImpl;

/**
 * Unit test for simple App.
 */
public class GetUserTest {

	GetUser service;

    @Before
    public void initialize() {
    	service = new GetUserImpl(); 
     }

	
	@Test
	public void testOkGetUser() {
		Assert.assertEquals(new Long(1),service.getUser("user1"));
	}
	
	@Test
	public void testNoUserFoundGetUser() {
		Assert.assertEquals(new Long(0),service.getUser("user0"));
	}
	

}
