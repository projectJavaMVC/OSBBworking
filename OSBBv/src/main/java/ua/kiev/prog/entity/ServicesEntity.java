package ua.kiev.prog.entity;

import javax.persistence.*;

/**
 * Created by mbro8_000 on 26.11.2015.
 */
@Entity
@Table(name = "services")
public class ServicesEntity {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public ServicesEntity(String name) {
        this.name = name;
    }

    public ServicesEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
