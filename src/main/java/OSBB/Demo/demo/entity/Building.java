package OSBB.Demo.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пользователь on 18.11.2015.
 */
@Entity
@Table(name="Building")
public class Building {
    @Id
    @GeneratedValue
    private long build_id;

    @OneToMany(mappedBy="building", cascade=CascadeType.ALL)
    private List<User> user = new ArrayList<User>();

    @Column
    private String build_code;


    public Building() {
    }

    public Building(String build_code) {
        this.build_code = build_code;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getBuild_code() {
        return build_code;
    }

    public void setBuild_code(String build_code) {
        this.build_code = build_code;
    }
}
