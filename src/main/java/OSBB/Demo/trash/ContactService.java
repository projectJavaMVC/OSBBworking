package OSBB.Demo.trash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDAO contactDAO;
    @Autowired
    private GroupDAO groupDAO;

    @Transactional
    public void addContact(Contact contact) {
        contactDAO.add(contact);
    }

    @Transactional
    public void addGroup(Group group) {
        groupDAO.add(group);
    }

    @Transactional
    public void deleteContact(long[] ids) {
        contactDAO.delete(ids);
    }

    @Transactional
    public void deleteGroup(Group group) {
        groupDAO.delete(group);
    }

    @Transactional(readOnly=true)
    public List<Group> listGroups() {
        return groupDAO.list();
    }

    @Transactional(readOnly=true)
    public List<Contact> listContacts(Group group) {
        return contactDAO.list(group);
    }

    @Transactional(readOnly=true)
    public Group findGroup(long id) {
        return groupDAO.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<Contact> searchContacts(String pattern) {
        return contactDAO.list(pattern);
    }
}
