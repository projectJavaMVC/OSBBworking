package ua.kiev.prog.DAO;

import ua.kiev.prog.entity.BuildsEntity;

/**
 * Created by m.bratyuk on 23.11.2015.
 */
public interface BuildDAO {
    void addBuild(BuildsEntity build);
    BuildsEntity getIDByKey (String key);
    void mergeBuild (BuildsEntity build);

}
