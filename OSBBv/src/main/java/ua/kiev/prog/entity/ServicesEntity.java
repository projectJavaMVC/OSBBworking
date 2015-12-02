package ua.kiev.prog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "servicesEntity", targetEntity = BuildServices.class)
    private List<BuildServices> buildservices = new ArrayList<BuildServices>();

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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id).append(" ").append(this.name);
        return sb.toString();
    }
}
