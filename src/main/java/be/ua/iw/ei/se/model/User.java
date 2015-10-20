package be.ua.iw.ei.se.model;

import java.util.List;

/**
 * Created by Kevin on 8/10/2015.
 */
public class User {
    private String firstName;
    private String lastName;
    private List<Role> roles;
    private String userName;
    private String password;

    public User (){

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getUserName() {return userName;}
    public void setUserName(String userName){this.userName = userName;}
    public String getPassword() {return password;}
    public void setPassWord(String password){this.password = password;}



}

