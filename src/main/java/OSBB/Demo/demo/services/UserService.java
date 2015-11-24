package OSBB.Demo.demo.services;

import OSBB.Demo.demo.entity.User;

import java.util.List;

/**
 * Created by Пользователь on 19.11.2015.
 */

public interface UserService {
        User getUserByLogin(String login);
        List<User> getAllUsers();
        void addUser(User user);
}
