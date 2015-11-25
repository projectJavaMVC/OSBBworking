package ua.kiev.prog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kiev.prog.DAO.BuildDAO;
import ua.kiev.prog.DAO.FlatDAO;
import ua.kiev.prog.DAO.UserDAO;
import ua.kiev.prog.DAO.UserInfoDAO;
import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.entity.FlatsEntity;
import ua.kiev.prog.entity.UserEntity;
import ua.kiev.prog.entity.UserInfoEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mbro8_000 on 23.11.2015.
 */
@Service
public class Services {

    @Autowired
    private BuildDAO buildDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserInfoDAO userInfoDAO;
    @Autowired
    private FlatDAO flatDAO;

    @Transactional
    public void addBuild (BuildsEntity build){
        buildDAO.addBuild(build);

    }

    @Transactional
    public UserEntity getUserByLogin(String login){
        return userDAO.getUserByLogin(login);
    }

    @Transactional
    public BuildsEntity getBuildByKey(String key){
        return buildDAO.getIDByKey(key);
    }


    @Transactional
    public void addUser (UserEntity user){
        userDAO.add(user);
    }

    @Transactional
    public void addUserInfo (UserInfoEntity userIE){
        userInfoDAO.add(userIE);
    }

    @Transactional
    public List<UserEntity> listUsers (BuildsEntity build){
        return userDAO.listUsers(build);
    }
    @Transactional
    public void mergeBuild (BuildsEntity build) {buildDAO.mergeBuild(build);}
    @Transactional
    public void addFlat(FlatsEntity flat){
       flatDAO.addFlat(flat);
    }
    @Transactional
    public List<FlatsEntity> listFlat(BuildsEntity buildsEntity){
        return (List<FlatsEntity>) flatDAO.listFlat(buildsEntity);
    }
    @Transactional
    public FlatsEntity getFlatById(long id){
        return flatDAO.getFlatByID(id);
    }
    @Transactional
    public FlatsEntity mergeFlat(FlatsEntity flatsEntity){
        return flatDAO.mergeFlat(flatsEntity);

    }
}
