package OSBB.Demo.trash;

import java.util.List;

public interface ContactDAO {
    void add(Contact contact);
    void delete(Contact contact);
    void delete(long[] ids);
    List<Contact> list(Group group);
    List<Contact> list(String pattern);
}
