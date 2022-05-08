package de.th_luebeck.swt2praktikum.controllers.Login;



/**
 * @author Bine
 * This class is used as data transfer object.
 */
public class LoginInput {
    private String userName;
    private String userPassword;

    public LoginInput(){}

    public LoginInput(String uN, String uP){
        this.userName = uN;
        this.userPassword = uP;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
