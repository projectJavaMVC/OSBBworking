package OSBB.Demo.demo.services;

import OSBB.Demo.demo.User;
import org.springframework.stereotype.Service;

/**
 * Created by ������������ on 19.11.2015.
 */
@Service
public interface UserService {
        public User getUserByLogin(String login);
}
