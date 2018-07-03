package messenger.ChatService;

import java.util.List;

public interface ManageContactList {
	
	/**
	 * adds a contact to user contact list
	 * @param userid		id of the user
	 * @param contactid		id of the contact (a contact is also a user)
	 * @return				true: the contact was added
	 */
	public boolean addContact(Long userId, Long contactId);
	
	/**
	 * deletes a user from a user contact list
	 * @param userid unique id of the user
	 * @param contactid unique id of the contact (a contact is also a user)
	 * @return true: contact succesful deleted false: deleting of the contact failed
	 */
	public boolean deleteContact(Long userId, Long contactId);
	
	/**
	 * returns an array with all the contact of a user
	 * @param userid unique id of the user
	 * @return List of contact-ids belonging to the contacts of the user
	 */
	public List<Long> getContactList(Long userId);
	
}
