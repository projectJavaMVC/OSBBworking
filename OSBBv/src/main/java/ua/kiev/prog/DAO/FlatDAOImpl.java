package ua.kiev.prog.DAO;

import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.entity.FlatsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by mbro8_000 on 25.11.2015.
 */
@Repository
public class FlatDAOImpl implements FlatDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FlatsEntity getFlatByID(long ID) {
        Query query;
        query = entityManager.createQuery("SELECT f from FlatsEntity f where ID=:id",FlatsEntity.class);
        query.setParameter("id",ID);
        return (FlatsEntity) query.getSingleResult();
    }

    @Override
    public void addFlat(FlatsEntity flat) {
        entityManager.persist(flat);
    }

    @Override
    public FlatsEntity mergeFlat(FlatsEntity flat) {
       return entityManager.merge(flat);
    }

    @Override
    public List<FlatsEntity> listFlat(BuildsEntity buildsEntity) {
        Query query;
        query = entityManager.createQuery("SELECT f from FlatsEntity f where buildsEntity=:build",FlatsEntity.class);
        query.setParameter("build",buildsEntity);
        return (List<FlatsEntity>) query.getResultList();
    }
}
