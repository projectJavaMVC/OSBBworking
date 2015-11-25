package ua.kiev.prog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    private UserEntityRepository userEntityRepository;


    @Transactional
    public UserEntity savefl(UserEntity userEntity){
       return userEntityRepository.saveAndFlush(userEntity);
    }


}
