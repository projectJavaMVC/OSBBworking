package ua.kiev.prog.DAO;


import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.entity.FlatsEntity;

import java.util.List;

/**
 * Created by mbro8_000 on 25.11.2015.
 */

public interface FlatDAO {
    void addFlat(FlatsEntity flat);
    List<FlatsEntity> listFlat(BuildsEntity buildsEntity);
    FlatsEntity getFlatByID (long id);
}
