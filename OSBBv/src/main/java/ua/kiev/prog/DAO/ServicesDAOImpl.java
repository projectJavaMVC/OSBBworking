package ua.kiev.prog.DAO;

import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mbro8_000 on 26.11.2015.
 */
@Repository
public class ServicesDAOImpl implements ServicesDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void tableFill() {
        Query query =entityManager.createQuery("SELECT s from ServicesEntity s where id=1",ServicesEntity.class);
        List list =   query.getResultList();

        if (list.isEmpty()){
            entityManager.persist(new ServicesEntity("ГИОЦ"));
            entityManager.persist(new ServicesEntity("КиевГаз"));
            entityManager.persist(new ServicesEntity("КиевВодоканал"));
            entityManager.persist(new ServicesEntity("КиевЕнерго"));
            entityManager.persist(new ServicesEntity("Другие Комунальные"));
            entityManager.persist(new ServicesEntity("КиевЛифт"));

        }
        //query = entityManager.createQuery("SELECT b from BuildsEntity b where id=1", BuildsEntity.class);
        //list =   query.getResultList();
        if (list.isEmpty()) {
            BuildsEntity buildsEntity1 = new BuildsEntity("", (short) 5,"Kiev","Sttrr","1223");
            BuildsEntity buildsEntity2 = new BuildsEntity("", (short) 15,"Odess","Sttr2r","123412");
            BuildsEntity buildsEntity3 = new BuildsEntity("", (short) 25,"Kiev","Sttrr23","2132412");
            entityManager.persist(buildsEntity1);
            entityManager.persist(buildsEntity2);
            entityManager.persist(buildsEntity3);
            UserEntity user1 = new UserEntity("admin","admin","mail1@mail", (short) 1,buildsEntity1);
            UserEntity user2 = new UserEntity("admin2","admin","mail2@mail", (short) 1,buildsEntity2);
            UserEntity user3 = new UserEntity("admin3","admin","mail3@mail", (short) 1,buildsEntity3);
            UserEntity user4 = new UserEntity("user","11","userl1@mail", (short) 0,buildsEntity1);
            UserEntity user5 = new UserEntity("user2","11","userl2@mail", (short) 0,buildsEntity1);
            UserEntity user6 = new UserEntity("user3","11","userl3@mail", (short) 0,buildsEntity2);
            UserEntity user7 = new UserEntity("user4","11","userl4@mail", (short) 0,buildsEntity3);
            entityManager.persist(user1);
            entityManager.persist(user2);
            entityManager.persist(user3);
            entityManager.persist(user4);
            entityManager.persist(user5);
            entityManager.persist(user6);
            entityManager.persist(user7);
            entityManager.merge(user1);
            entityManager.merge(user2);
            entityManager.merge(user3);
            entityManager.merge(user4);
            entityManager.merge(user5);
            entityManager.merge(user6);
            entityManager.merge(user7);
            for (int i = 1; i <=buildsEntity1.getFlatCnt(); i++) {
                FlatsEntity flat = new FlatsEntity() ;
                flat.setFlatNumber(i);
                flat.setBuildsEntity(buildsEntity1);
                flat.setArea(BigDecimal.valueOf(i + 3.00));
                flat.setPeopleCnt(i>5?i-3:i+1);
                entityManager.persist(flat);
            }
            for (int i = 1; i <=buildsEntity2.getFlatCnt(); i++) {
                FlatsEntity flat = new FlatsEntity() ;
                flat.setFlatNumber(i);
                flat.setBuildsEntity(buildsEntity2);
                flat.setArea(BigDecimal.valueOf(i+11.00));
                flat.setPeopleCnt(i>5?i-3:i+1);
                entityManager.persist(flat);
            }
            for (int i = 1; i <=buildsEntity3.getFlatCnt(); i++) {
                FlatsEntity flat = new FlatsEntity() ;
                flat.setFlatNumber(i);
                flat.setBuildsEntity(buildsEntity3);
                flat.setArea(BigDecimal.valueOf(i+7.00));
                flat.setPeopleCnt(i>5?i-2:i+1);
                entityManager.persist(flat);
            }
            query = entityManager.createQuery("Select f from FlatsEntity f where buildsEntity=:buildsEntity",FlatsEntity.class).setParameter("buildsEntity",buildsEntity1);
            list = query.getResultList();


            UserInfoEntity userInf4 = new UserInfoEntity("Name1","lastName1","SecondName1","0932323195",user4,(FlatsEntity)list.get(1));
            entityManager.persist(userInf4);
            UserInfoEntity userInf5 = new UserInfoEntity("Name21","lastName2","SecondName2","0232323155",user5,(FlatsEntity)list.get(2));
            entityManager.persist(userInf5);
            query = entityManager.createQuery("Select f from FlatsEntity f where buildsEntity=:buildsEntity",FlatsEntity.class).setParameter("buildsEntity",buildsEntity2);
            list = query.getResultList();

            UserInfoEntity userInf6 = new UserInfoEntity("Name31","lastName3","SecondName3","0932324355",user6,(FlatsEntity)list.get(3));
            entityManager.persist(userInf6);
            query = entityManager.createQuery("Select f from FlatsEntity f where buildsEntity=:buildsEntity",FlatsEntity.class).setParameter("buildsEntity",buildsEntity3);
            list = query.getResultList();
            UserInfoEntity userInf7 = new UserInfoEntity("Name41","lastName41","SecondName41","0742324355",user1,(FlatsEntity)list.get(1));
            entityManager.persist(userInf7);
        }


    }

    @Override
    public List<ServicesEntity> listServices() {
        return entityManager.createQuery("SELECT s from ServicesEntity s",ServicesEntity.class).getResultList();
    }
}
