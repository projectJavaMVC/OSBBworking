package ua.kiev.prog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.BuildsEntity;


/**
 * Created by Пользователь on 30.11.2015.
 */

public interface BuildsEntityRepository extends JpaRepository<BuildsEntity, Long>{

}
