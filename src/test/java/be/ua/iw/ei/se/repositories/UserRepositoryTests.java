package be.ua.iw.ei.se.repositories;

import be.ua.iw.ei.se.IdTestManagerApplication;
import be.ua.iw.ei.se.model.User;
import be.ua.iw.ei.se.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Kevin on 22/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IdTestManagerApplication.class)
@WebAppConfiguration
public class UserRepositoryTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveProduct() {
        //setup product
        User user = new User();
        user.setUserName("TestUserName");

        //save product, verify has ID value after save
        Assert.assertNull(user.getId()); //null before save
        userRepository.save(user);
        Assert.assertNotNull(user.getId()); //not null after save          //bullshit

        //fetch from DB
        User fetchedUser = userRepository.findOne(user.getId());

        //should not be null
        Assert.assertNotNull(fetchedUser);

        //should equal
        Assert.assertEquals(user.getId(), fetchedUser.getId());
        Assert.assertEquals(user.getUserName(), fetchedUser.getUserName());

        //update description and save
        fetchedUser.setUserName("NewTestUserName");
        userRepository.save(fetchedUser);

        //get from DB, should be updated
        User fetchedUpdatedUser = userRepository.findOne(fetchedUser.getId());
        Assert.assertEquals(fetchedUser.getUserName(), fetchedUpdatedUser.getUserName());

        //verify count of products in DB
        long userCount = userRepository.count();
        Assert.assertEquals(userCount, 3);

        //get all products, list should only have one more then initial value
        Iterable<User> users = userRepository.findAll();

        int count = 0;

        for (User p : users) {
            count++;
        }

        Assert.assertEquals(count, 3);// we starten reeds met 2 gebruikers in de database
    }
}

