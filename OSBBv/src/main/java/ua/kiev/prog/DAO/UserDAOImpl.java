package ua.kiev.prog.DAO;

import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by mbro8_000 on 23.11.2015.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity getUserByLogin(String login) {
        return entityManager.createQuery("SELECT u from UserEntity u where login=:login",UserEntity.class).setParameter("login",login).getSingleResult();
    }

    @Override
    public List<UserEntity> listUsers(BuildsEntity build) {
        Query query = entityManager.createQuery("SELECT u from UserEntity u where type = 0 and u.buildsEntity=:build", UserEntity.class).setParameter("build",build);

        return (List<UserEntity>) query.getResultList();
    }

    @Override
    public void add(UserEntity user) {
        entityManager.persist(user);
    }


    @Override
    public UserEntity mergeUser(UserEntity user) {
        return  entityManager.merge(user);

    }
}
