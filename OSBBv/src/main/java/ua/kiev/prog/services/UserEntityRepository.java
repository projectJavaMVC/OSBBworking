package ua.kiev.prog.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.entity.UserEntity;

/**
 * Created by mbro8_000 on 25.11.2015.
 */
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
