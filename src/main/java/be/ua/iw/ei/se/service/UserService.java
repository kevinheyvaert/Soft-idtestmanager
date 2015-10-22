package be.ua.iw.ei.se.service;

import be.ua.iw.ei.se.model.User;
import be.ua.iw.ei.se.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kevin on 8/10/2015.
 */
@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;
   // public List<User> findAll() {return this.userRepository.findAll();}
    public Iterable<User> findAll() {return this.userRepository.findAll();}
    //public Iterable<Role> getRoles() {return this.userRepository.findAll();}



    public void add(final User user) {

        this.userRepository.save(user); //ipv add
    }

    public void delete(Long id) {
        this.userRepository.delete(id);
    }

    /*
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails ud = null;
        for (User user : findAll()){
            if (userName.equals(user.getUserName())){
                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                for (Role role : user.getRoles()) {
                    for (Permission perm : role.getPermissions()){
                        authorities.add(new SimpleGrantedAuthority(perm.getName()));
                    }
                }

                ud = new org.springframework.security.core.userdetails.User(userName, user.getPassword(), true, true, true, true,authorities);
            }
        }
        if (ud == null) throw new UsernameNotFoundException("No user with username '" + userName + "' found!");
        return ud;
    }
    */

    public User findByUserName(String userName) {return userRepository.findByUserName(userName);
    }
}
