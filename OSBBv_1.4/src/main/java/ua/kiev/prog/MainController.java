package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kiev.prog.entity.*;
import ua.kiev.prog.services.Services;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    static final int USER_TYPE = 0;
    static final int ADMIN_TYPE = 1;

    @Autowired
    private Services services;

    @RequestMapping("/sec/signIN")
    public String signin(Model model) {
        UserEntity user = getCurrUser();

        model.addAttribute("servicesList", getCurrentUserServiceList(user));
        model.addAttribute("user", user);
        model.addAttribute("users", getCurrentUserList(user));

        return user.getType() == USER_TYPE ? "user/main/mainuser" : "admin/main/mainadmin";
    }

    @RequestMapping("/user/add/currentvalue/{id}")
    public String listGroup(@PathVariable("id") long servId, @RequestParam int rate, @RequestParam long currentvalue, Model model) {

        UserEntity user = getCurrUser();
        CountData data = new CountData();
        data.setServicesEntity(services.getServiceById(servId));
        data.setRate(rate);
        data.setValue(currentvalue);
        data.setUserEntity(user);
        services.addCountData(data);

        ////Вынести в метод инициализацию а и прокрутить тут.
        return "user/main/mainuser";
    }

    public List<User> getCurrentUserList(UserEntity user) {
        List<UserEntity> listUsers = services.findAllUsersByBuild(user.getBuildsEntity());
        List<User> listUser = new ArrayList<User>();
        for (UserEntity u : listUsers) {
            if (u.getUserInfo() != null) {
                User us = new User(u);
                listUser.add(us);
            }
        }
        return listUser;
    }

    public List<ServiceUser> getCurrentUserServiceList(UserEntity user) {
        List<ServiceUser> serviceUserList = new ArrayList<ServiceUser>();
        List<BuildServices> buildServicesList = user.getBuildsEntity().getServices();
        for (BuildServices buildServ : buildServicesList) {
            ServiceUser serviceUser = new ServiceUser();
            serviceUser.setName(buildServ.getServicesEntity().getName());
            serviceUser.setServiceId(buildServ.getServicesEntity().getId());
            serviceUser.setRate(buildServ.getRate());
            serviceUser.setLastValue(services.findLastValue(user, buildServ.getServicesEntity()) == null ? 0 : services.findLastValue(user, buildServ.getServicesEntity()).getValue());
            serviceUserList.add(serviceUser);
        }
        return serviceUserList;
    }

    public UserEntity getCurrUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return services.findOneUserByLogin(login);
    }
}
