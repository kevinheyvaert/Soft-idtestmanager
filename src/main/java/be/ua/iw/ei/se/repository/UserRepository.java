package be.ua.iw.ei.se.repository;

import be.ua.iw.ei.se.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kevin on 8/10/2015.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}




