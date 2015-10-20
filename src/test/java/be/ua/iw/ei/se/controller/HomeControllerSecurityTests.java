package be.ua.iw.ei.se.controller;

import be.ua.iw.ei.se.IdTestManagerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

import org.springframework.security.access.AccessDeniedException;
//import java.nio.file.AccessDeniedException;

/**
 * Created by Kevin on 20/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IdTestManagerApplication.class)
@WebAppConfiguration
public class HomeControllerSecurityTests {
    @Autowired
    private HomeController homeController;

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void testOne() {

        homeController.showHomepage(new ModelMap());
    }

    @Test(expected = AccessDeniedException.class)
    @WithMockUser(roles={"ADMIN"})
    public void testTwo()
    {
        homeController.showHomepage(new ModelMap());
    }
    @Test(expected = AccessDeniedException.class)
    @WithMockUser(username = "ravan")
    public void testThree()
    {
        homeController.showHomepage(new ModelMap());
    }
    @Test
    @WithUserDetails("root")
    public void testFour() {
        homeController.showHomepage(new ModelMap());
    }


}
