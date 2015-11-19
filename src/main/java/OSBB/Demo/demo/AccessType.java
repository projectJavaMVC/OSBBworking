package OSBB.Demo.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пользователь on 18.11.2015.
 */
@Entity
@Table(name = "AccessType")
public class AccessType {

    @Id
    @GeneratedValue
    private long type_id;

    @OneToMany(mappedBy = "accessTypes")
    private List<User> users = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Types type;

    public AccessType() {
    }

    public AccessType(long id) {
        this.type_id = id;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
}
