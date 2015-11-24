package ua.kiev.prog.DAO;

import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.BuildsEntity;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by m.bratyuk on 23.11.2015.
 */
@Repository
public class BuildDAOImpl implements BuildDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BuildsEntity getIDByKey(String key) {
        Query query=null;

        if (key != null) {
            query = entityManager.createQuery("SELECT c FROM BuildsEntity c where c.code = :key ", BuildsEntity.class);
            query.setParameter("key", key);
    }
    return (BuildsEntity) query.getSingleResult();
    }

    @Override
    public void mergeBuild(BuildsEntity build) {
        entityManager.merge(build);
    }

    @Override
    public void addBuild(BuildsEntity build) {
        entityManager.persist(build);
        entityManager.refresh(build);
    }
}
