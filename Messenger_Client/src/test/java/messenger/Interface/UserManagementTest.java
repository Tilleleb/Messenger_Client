package messenger.Interface;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import messenger.ChatService.UserManagement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserManagementTest {


	@Autowired
	UserManagement userManagement;

	@Test
	public void testOkAddUser() {
		Assert.assertEquals(0,userManagement.addUser("user1", "password1"));
	}
	
//<<<<<<< HEAD
//	@Test
//	public void testAlreadyExistAddUser() {
//		service.addUser("user1", "password1");
//		Assert.assertEquals(1,service.addUser("user1", "password1"));
//	}
//	
//	@Test
//	public void testErrorAddUser() {
//		Assert.assertEquals(2,service.addUser("user2", "password2"));
//	}
//	
//	// Test delete User
//	
//	@Test
//	public void testOkDeleteUser() {
//		service.addUser("user1", "password1");
//		Assert.assertTrue(service.deleteUser(1));
//	}
//	
//	@Test
//	public void testErrorDeleteUser() {
//		Assert.assertFalse(service.deleteUser(0));
//	}
//	
//	
//	// test update User
//
//	@Test
//	public void testOkUpdateUser() {
//		service.addUser("user1", "password1");
//		Assert.assertTrue(service.updateUser(1, "user1", "password1"));
//	}
//	
//	@Test
//	public void testWrongUserUpdateUser() {
//		service.addUser("user1", "password1");
//		Assert.assertFalse(service.updateUser(0, "user1", "password1"));
//	}
//	
//	@Test
//	public void testEmptyPwUpdateUser() {
//		service.addUser("user1", "password1");
//		Assert.assertFalse(service.updateUser(1, "user1", ""));
//	}
//	
//	@Test
//	public void testEmptyUsernameUpdateUser() {
//		service.addUser("user1", "password1");
//		Assert.assertFalse(service.updateUser(1, "", "password1"));
//	}
//	
//	@Test
//	public void testWrongSignsUpdateUser() {
//		service.addUser("user1", "password1");
//		Assert.assertFalse(service.updateUser(1, "user1%", "password1"));
//	}
//	
//	
//	// test loginUser
//	//public int loginUser(String username, String password);
//	
//	@Test
//	public void testOkLoginUser() {
//		service.addUser("user1", "password1");
//		Assert.assertEquals(1, service.loginUser("user1", "password1"));
//	}
//	
//	@Test
//	public void testNoMatchLoginUser() {
//		service.addUser("user1", "password1");
//		Assert.assertEquals(0, service.loginUser("user0", "password0"));
//	}
//=======
	@Test
	public void testAlreadyExistAddUser() {
		userManagement.addUser("user1", "password1");
		Assert.assertEquals(1,userManagement.addUser("user1", "password1"));
	}
	
	@Test
	public void testErrorAddUser() {
		Assert.assertEquals(2,userManagement.addUser("user2", "password2"));
	}
	
	// Test delete User
	
	@Test
	public void testOkDeleteUser() {
		userManagement.addUser("user1", "password1");
		Assert.assertTrue(userManagement.deleteUser((long) 1));
	}
	
	@Test
	public void testErrorDeleteUser() {
		Assert.assertFalse(userManagement.deleteUser((long) 0));
	}
	
	
	// test update User

	@Test
	public void testOkUpdateUser() {
		userManagement.addUser("user1", "password1");
		Assert.assertTrue(userManagement.updateUser((long) 1, "user1", "password1"));
	}
	
	@Test
	public void testWrongUserUpdateUser() {
		userManagement.addUser("user1", "password1");
		Assert.assertFalse(userManagement.updateUser((long) 0, "user1", "password1"));
	}
	
	@Test
	public void testEmptyPwUpdateUser() {
		userManagement.addUser("user1", "password1");
		Assert.assertFalse(userManagement.updateUser((long) 1, "user1", ""));
	}
	
	@Test
	public void testEmptyUsernameUpdateUser() {
		userManagement.addUser("user1", "password1");
		Assert.assertFalse(userManagement.updateUser((long) 1, "", "password1"));
	}
	
	@Test
	public void testWrongSignsUpdateUser() {
		userManagement.addUser("user1", "password1");
		Assert.assertFalse(userManagement.updateUser((long) 1, "user1%", "password1"));
	}
	
	
	// test loginUser
	//public int loginUser(String username, String password);
	
	@Test
	public void testOkLoginUser() {
		userManagement.addUser("user1", "password1");
		Assert.assertEquals(1, userManagement.loginUser("user1", "password1"));
	}
	
	@Test
	public void testNoMatchLoginUser() {
		userManagement.addUser("user1", "password1");
		Assert.assertEquals(0, userManagement.loginUser("user0", "password0"));
	}
//>>>>>>> branch 'master' of https://github.com/Tilleleb/messengerMaven
	
}
