package ua.kiev.prog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.entity.FlatsEntity;
import ua.kiev.prog.entity.UserEntity;

import java.util.List;


/**
 * Created by ������������ on 30.11.2015.
 */

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
   // @Query("SELECT * from users u where login=:login")
    //UserEntity getUserByLogin(@Param("login")String login);
    UserEntity findOneByLogin (String login);
    List<UserEntity> findAllByBuildsEntity (BuildsEntity buildsEntity);
    UserEntity findOneByBuildsEntity (BuildsEntity buildsEntity);
}
