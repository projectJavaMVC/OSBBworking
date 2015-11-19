package OSBB.Demo.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Пользователь on 19.11.2015.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(String login) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.user_login =:login", User.class);
        return (User) query.getSingleResult();
    }
}
