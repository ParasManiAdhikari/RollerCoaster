package de.th_luebeck.swt2praktikum.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_User")
public class User {
    /**
     * The GenerationType.AUTO is the default generation type and
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id", updatable = false)
    private long id;

    /**
     * Fields to be stored as a user's information.
     */

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email" , unique = true,nullable = false)
    private String email;

    @Column(name = "username",unique = true,nullable = false)
    private String userName;

    @Column(name = "password",nullable = false)
    private String password;

    public Integer fahrten;

    /**
     * Constructor with parameters for quick-instantiation
     * @param name the user's name
     * @param userName the user's username
     * @param password the user's password
     * @param email the user's email
     */
    public User( String userName, String password, String email,String name) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;

        this.fahrten = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName)
                && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + "username" + userName + '}';
    }

    // Getters & setters:
    public String getBenutzerName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Integer getFahrten() {return fahrten;}

}
