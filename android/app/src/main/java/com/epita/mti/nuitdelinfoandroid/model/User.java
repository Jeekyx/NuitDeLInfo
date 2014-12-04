package com.epita.mti.nuitdelinfoandroid.model;

/**
 * Created by yvan on 12/4/14.
 */
public class User extends Model {
    private String login;
    private String password;
    private UserType type;

    public enum UserType {
        VOLUNTEER,
        CHARITY
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
