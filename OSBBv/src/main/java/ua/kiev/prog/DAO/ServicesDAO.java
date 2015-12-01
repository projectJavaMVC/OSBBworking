package ua.kiev.prog.DAO;

import ua.kiev.prog.entity.ServicesEntity;

import java.util.List;

/**
 * Created by mbro8_000 on 26.11.2015.
 */
public interface ServicesDAO  {
    void tableFill();
    List<ServicesEntity> listServices();
}
