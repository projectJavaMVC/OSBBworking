package ua.kiev.prog.DAO;

import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.FlatsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mbro8_000 on 25.11.2015.
 */
@Repository
public class FlatDAOImpl implements FlatDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addFlat(FlatsEntity flat) {
        entityManager.persist(flat);
    }
}
