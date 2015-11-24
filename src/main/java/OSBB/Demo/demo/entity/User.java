package OSBB.Demo.demo.entity;

import javax.persistence.*;

/**
 * Created by Пользователь on 18.11.2015.
 */
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private long user_id;

    @Column(name = "user_login")
    private String user_login;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "user_email")
    private String user_email;

    @ManyToOne
    @JoinColumn(name = "build_id")
    private Building building;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private OSBB.Demo.demo.entity.AccessType type;

    public User(String user_login, String user_password, Building building, OSBB.Demo.demo.entity.AccessType type, String user_email) {
        this.user_login = user_login;
        this.user_password = user_password;
        this.building = building;
        this.type = type;
        this.user_email = user_email;
    }

    public User() {
    }


    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public OSBB.Demo.demo.entity.AccessType getType() {
        return type;
    }

    public void setType(OSBB.Demo.demo.entity.AccessType type) {
        this.type = type;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
