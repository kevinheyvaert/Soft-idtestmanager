package be.ua.iw.ei.se.repository;

import be.ua.iw.ei.se.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kevin on 22/10/2015.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findByName(String name);
    //Role findByRoleName(String name);
}