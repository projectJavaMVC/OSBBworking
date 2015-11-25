package ua.kiev.prog.repository;

/**
 * Created by mbro8_000 on 25.11.2015.
 */
import org.springframework.data.repository.CrudRepository;
import ua.kiev.prog.entity.User;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
