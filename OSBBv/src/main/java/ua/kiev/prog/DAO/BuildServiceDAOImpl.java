package ua.kiev.prog.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.BuildServices;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mbro8_000 on 02.12.2015.
 */
@Repository
public class BuildServiceDAOImpl implements   BuildServiceDAO {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addBuildService(BuildServices buildServices) {
        entityManager.persist(buildServices);
    }
}
