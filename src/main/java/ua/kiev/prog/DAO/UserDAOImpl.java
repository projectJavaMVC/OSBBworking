package ua.kiev.prog.DAO;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.entity.UserEntity;

import java.util.List;

/**
 * Created by mbro8_000 on 23.11.2015.
 */
@Repository
public class UserDAOImpl implements UserDAO{
         @PersistenceContext
        private EntityManager entityManager;

   @Override
    public List<UserEntity> list(BuildsEntity build) {
        Query query=null;
        if (build==null) {
            query = entityManager.createQuery("SELECT u from UserEntity u", UserEntity.class);
        }
        return (List<UserEntity>) query.getResultList();
    }

    @Override
    public void add(UserEntity user){
        entityManager.persist(user);
    }

}
