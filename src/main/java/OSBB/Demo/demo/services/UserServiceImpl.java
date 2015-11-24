package OSBB.Demo.demo.services;

import OSBB.Demo.demo.DAO.UserDAO;
import OSBB.Demo.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Пользователь on 19.11.2015.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public List<User> getAllUsers() {
        List<User> users;
        users = userDAO.getAll();
        return users;
    }

    @Transactional
    public User getUserByLogin(String login) {
        User user = userDAO.getUser(login);
        return user;
    }

    @Transactional
    public void addUser(User user) {
        userDAO.addUserToDatabase(user);
    }
}
