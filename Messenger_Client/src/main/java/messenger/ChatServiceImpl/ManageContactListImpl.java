package messenger.ChatServiceImpl;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.ChatService.ManageContactList;
import messenger.DbService.UserService;
import messenger.Domain.User;

@Service
@Scope("singleton")
public class ManageContactListImpl implements ManageContactList, Serializable {

	@Autowired
	private UserService userDbService;

	@Transactional
	public boolean addContact(Long userId, Long contactId) {
		User user = userDbService.getUserById(userId);
		User contact = userDbService.getUserById(contactId);
		user.getContacts().add(contact);
		userDbService.persistObject(user);
		return true;
	}

	@Transactional
	public boolean deleteContact(Long userId, Long contactId) {
		User user = userDbService.getUserById(userId);
		User contact = userDbService.getUserById(contactId);
		user.getContacts().remove(contact);
		userDbService.persistObject(user);
		return true;
	}

	@Transactional
	public List<Long> getContactList(Long userId) {
		User user = userDbService.getUserById(userId);
		List<Long> contactIdList = new ArrayList<Long>();
		if (user == null) return contactIdList;
		List<User> contactList = user.getContacts();
		for (User contact : contactList) contactIdList.add(contact.getUserId());
		return contactIdList;
	}

}
