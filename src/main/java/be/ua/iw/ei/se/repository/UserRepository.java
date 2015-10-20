package be.ua.iw.ei.se.repository;

import be.ua.iw.ei.se.model.Permission;
import be.ua.iw.ei.se.model.Role;
import be.ua.iw.ei.se.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 8/10/2015.
 */
@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private final List<Role> roles = new ArrayList<>();
    private final List<Permission> permissions = new ArrayList<>();

    public UserRepository() {
        super();
        Permission p1 = new Permission("logon");
        Permission p2 = new Permission("secret-message");
        Role administrator = new Role("Administrator");
        Role tester = new Role("Tester");
        List<Permission> permissions =  new ArrayList<Permission>();
        permissions.add(p1);
        tester.setPermissions(permissions);
        permissions =  new ArrayList<Permission>();
        permissions.add(p1);
        permissions.add(p2);
        administrator.setPermissions(permissions);

        User u1 = new User("Kevin","Heyvaert" , "root", "root");
        List<Role> roles = new ArrayList<>();
        roles.add(administrator);
        u1.setRoles(roles);
        User u2 = new User("Jan","Jansens","Jan", "Jan");
        roles = new ArrayList<>();
        roles.add(tester);
        u2.setRoles(roles);

        users.add(u1);
        users.add(u2);
    }

    public List<User> findAll() {
        return new ArrayList<User>(this.users);
    }

    public void add(final User user) {
        this.users.add(user);
    }

    public List<Role> getRoles() { return new ArrayList<>(this.roles); }

    public List<Permission> getPermissions() { return new ArrayList<>(this.permissions); }

}
