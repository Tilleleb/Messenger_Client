package messenger.Interface;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import messenger.ChatService.ManageContactList;
import messenger.ChatServiceImpl.ManageContactListImpl;

public class ManageContactListTest {

	ManageContactList service;
	
    @Before
    public void initialize() {
    	service = new ManageContactListImpl();
     }


	// Test AddContact

	@Test
	public void testOkAddUser() {
		Assert.assertTrue(service.addContact(1L,2L));
	}
	
	@Test
	public void testUserDoesntExistAddUser() {
		Assert.assertFalse(service.addContact(3L,2L));
	}	
	
	@Test
	public void testContactDoesntExistAddUser() {
		Assert.assertFalse(service.addContact(1L,3L));
	}
	
	@Test
	public void testSelfAddingAddUser() {
		Assert.assertFalse(service.addContact(1L,1L));
	}
	
	// Test Delete Contact
	
	@Test
	public void testOkDeleteContact() {
		Assert.assertTrue(service.deleteContact(1L,2L));
	}
	
	@Test
	public void testUserDoesntExistDeleteContact() {
		Assert.assertFalse(service.deleteContact(3L,2L));
	}	
	
	@Test
	public void testContactDoesntExistDeleteContact() {
		Assert.assertFalse(service.deleteContact(1L,3L));
	}
	
	@Test
	public void testSelfAddingDeleteContact() {
		Assert.assertFalse(service.deleteContact(1L,1L));
	}
	
	
	// Test GetContactList
	@Test
	public void testOkGetContactlost() {
		Assert.assertNotNull(service.getContactList(1L));
	}
	
	@Test
	public void testNoContactListGetContactlost() {
		Assert.assertNull(service.getContactList(0L));
	}
	
}
