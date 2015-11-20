package OSBB.Demo.demo.DAO;

import OSBB.Demo.demo.entity.User;

import java.util.List;

/**
 * Created by Пользователь on 19.11.2015.
 */

public interface UserDAO {

    void addUserToDatabase(User user);
    User getUser(String login);
    List<User> getAll();
}
