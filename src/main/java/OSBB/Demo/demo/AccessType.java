package OSBB.Demo.demo;

import javax.persistence.*;

/**
 * Created by Пользователь on 18.11.2015.
 */
@Entity
@Table(name = "Type")
public class AccessType {
    private final String ADMIN = "Admin";
    private final String USER = "User";

    @Id
    @GeneratedValue
    private long type_id;

    @Column
    private String access_name;

    public AccessType(String access_name) {             //по умолчанию юзер регистрируется и автоматом получает тип - юзер,
        if (access_name.equalsIgnoreCase(ADMIN))        //при регистрации админа тип указываем явно.
            this.access_name = ADMIN;
        this.access_name = USER;                                        //TODO
    }

    public AccessType() {
        this.access_name = USER;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public String getAccess_name() {
        return access_name;
    }

    public void setAccess_name(String access_name) {
        this.access_name = access_name;
    }
}
