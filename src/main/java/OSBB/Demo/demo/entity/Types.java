package OSBB.Demo.demo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пользователь on 19.11.2015.
 */
public enum Types {
    USER, ADMIN;

    public static List<Types> getAll(){
        List<Types> result = new ArrayList<>();
        result.add(USER);
        result.add(ADMIN);
        return result;
    }

    public String getName(){
        return this.name();
    }
}
