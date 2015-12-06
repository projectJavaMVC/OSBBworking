package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kiev.prog.entity.*;
import ua.kiev.prog.services.Services;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbro8_000 on 05.12.2015.
 */
@Controller
@RequestMapping("/")
public class MainController {
    static final int USER_TYPE = 0;
    static final int ADMIN_TYPE = 1;

    private UserEntity getCurrUser(){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return services.findOneUserByLogin(login);
    }

    @Autowired
    private Services services;

    @RequestMapping("/sec/signIN")
    public String signin(  Model model) {
        UserEntity user = getCurrUser();
        List<UserEntity> listUsers = services.findAllUsersByBuild(user.getBuildsEntity());
        List<User> listUser = new ArrayList<User>();
        for (UserEntity u : listUsers) {
            User us = new User(u);
            listUser.add(us);
        }
        List<ServicesEntity> servicesEntityList = new ArrayList<ServicesEntity>();
        List<BuildServices> buildServicesList = user.getBuildsEntity().getServices();
        for( BuildServices buildServ : buildServicesList){
            servicesEntityList.add(buildServ.getServicesEntity());
        }
        model.addAttribute("servicesList",servicesEntityList);
        model.addAttribute("user", user);
        model.addAttribute("users", listUser);
        return user.getType() == USER_TYPE ? "user/main/mainuser" : "admin/main/mainadmin";

    }


}
