package ua.kiev.prog.DAO;

import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.entity.UserEntity;

import java.util.List;

/**
 * Created by mbro8_000 on 23.11.2015.
 */
public interface UserDAO {
    void add(UserEntity user);
    List<UserEntity> list(BuildsEntity build);

}
