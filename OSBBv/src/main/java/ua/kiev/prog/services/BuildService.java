package ua.kiev.prog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kiev.prog.DAO.BuildDAO;
import ua.kiev.prog.entity.BuildsEntity;

import javax.transaction.Transactional;

/**
 * Created by m.bratyuk on 23.11.2015.
 */
@Service
public class BuildService {
    @Autowired
    private BuildDAO buildDAO;

    @Transactional
    public void addBuild (BuildsEntity build){
        buildDAO.mergeBuild(build);

    }

    @Transactional
    public BuildsEntity getBuildByKey(String key){
        return buildDAO.getIDByKey(key);
    }
}
