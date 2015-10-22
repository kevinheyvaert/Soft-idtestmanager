package be.ua.iw.ei.se.controller;

import be.ua.iw.ei.se.model.User;
import be.ua.iw.ei.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kevin on 8/10/2015.
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @ModelAttribute("allUsers")
    public Iterable<User> populateUsers() {
        return this.userService.findAll();
    }

    @RequestMapping({"/","/home"})
    @PreAuthorize("hasRole('logon')")
    public String showHomepage(ModelMap map){
        //User user  = new User("Kevin", "Heyvaert");
        //model.addAttribute("user", user);
        return "homepage";
    }
    @RequestMapping({"/admin"})
    @PreAuthorize("hasRole('administrator')")
    public String showAdmin() {
        return "admin";
    }

    //toegevoegd
    @ModelAttribute("newUser")
    public User newUser(String userName, String password, String firstName, String lastName) {
        return new User(userName, password, firstName, lastName);
    }

    @RequestMapping(value = "/admin", params = {"user"})
    public String saveUser(final User user, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        this.userService.add(user);
        model.clear();
        return "redirect:/admin";
    }
    /*
    @ModelAttribute("allRoles")
    public Iterable<Role> getRoles() {
        return this.userService.getRoles();
    }
    */
}
