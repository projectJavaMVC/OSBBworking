package ua.kiev.prog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kiev.prog.DAO.UserDAO;
import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.entity.UserEntity;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mbro8_000 on 23.11.2015.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Transactional
    public void addUser (UserEntity user){

        userDAO.add(user);
    }
    @Transactional
    public List<UserEntity> list (BuildsEntity build){
       return userDAO.list(build);
    }
}
