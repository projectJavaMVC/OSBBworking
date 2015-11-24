package ua.kiev.prog.DAO;

import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.UserInfoEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Пользователь on 24.11.2015.
 */
@Repository
public class UserInfoDAOImpl implements UserInfoDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(UserInfoEntity userIE) {
        entityManager.persist(userIE);
    }
}
