package be.ua.iw.ei.se.model;

/**
 * Created by Kevin on 8/10/2015.
 */
public class Permission {
    private String name;

    public Permission(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
