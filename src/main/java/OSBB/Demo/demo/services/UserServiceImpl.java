package OSBB.Demo.demo.services;

import OSBB.Demo.demo.User;
import OSBB.Demo.demo.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Пользователь on 19.11.2015.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUserByLogin(String login) {
        return userDAO.getUser(login);
    }
}
