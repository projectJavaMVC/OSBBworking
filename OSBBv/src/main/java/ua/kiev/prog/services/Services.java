package ua.kiev.prog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kiev.prog.entity.*;
import ua.kiev.prog.repositories.BuildsEntityRepository;
import ua.kiev.prog.repositories.ServicesEntityRepository;
import ua.kiev.prog.repositories.UserEntityRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mbro8_000 on 23.11.2015.
 */
@Service
public class Services {


    @Autowired
    private BuildsEntityRepository buildsEntityRepository;
    @Autowired
    private UserEntityRepository userEntityRepository;

    @Transactional
    public void addUser(UserEntity userEntity){
        userEntityRepository.saveAndFlush(userEntity);
    }
    @Transactional
    public List<UserEntity> findAllUsersByBuild(BuildsEntity buildsEntity) {
       return (List<UserEntity>) userEntityRepository.findAllByBuildsEntity(buildsEntity);
    }

    @Transactional
    public UserEntity findOneUsersByBuild(BuildsEntity buildsEntity) {
        return     userEntityRepository.findOneByBuildsEntity(buildsEntity);
    }

    @Transactional
    public BuildsEntity findBuildByID(Long id){
        return buildsEntityRepository.findOne(id);
    }



}
