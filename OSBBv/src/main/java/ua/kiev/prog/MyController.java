package ua.kiev.prog;

import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.kiev.prog.entity.*;
import ua.kiev.prog.services.Services;
import ua.kiev.prog.utils.Email;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes(names = {"build", "user", "userIE"}, types = {BuildsEntity.class, UserEntity.class, UserInfoEntity.class})
public class MyController {

    static final int USER_TYPE = 0;
    static final int ADMIN_TYPE = 1;

    @Autowired
    private Services services;


    /////--------------------Всеволод
    @RequestMapping("/")
    public String index(Model model) {
        return "hello/signIN";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {
        return "regist/signup";
    }


    @RequestMapping("/signup/add")
    public String addUser(@RequestParam String login, @RequestParam String pass, @RequestParam String email,
                          @RequestParam Short group, @RequestParam String key, Model model) {
        BuildsEntity build;

        String[] list = {login, pass, email};
        for (String s : list) {
            if((s == null)||(s.isEmpty()))
                return "errors/403_Error";
        }

        UserEntity user = null;
        if (group == USER_TYPE) {
            build = services.getBuildByKey(key);
            user = new UserEntity(login, pass, email, group, build);
            model.addAttribute("user", user);
            model.addAttribute("listFlat",services.listFlat(build));
        } else if (group == ADMIN_TYPE) {
            build = new BuildsEntity(null);
            services.addBuild(build);
            user = new UserEntity(login, pass, email, group, build);
            model.addAttribute("build", build);
        }

        services.addUser(user);
        return group == USER_TYPE ? "regist/user/signup2User" : "regist/admin/signup2Admin";
    }


    @RequestMapping("/signup/addAdmin2")
    public String addBuild(@RequestParam Short flatCnt, @RequestParam String city, @RequestParam String street,
                           @RequestParam String buildNum, @ModelAttribute("build") BuildsEntity build, Model model) {
        build.setBuildNum(buildNum);
        services.mergeBuild(build);
        if ( build.getId()!=0 ){
            for (int i = 1; i <= build.getFlatCnt(); i++) {
               FlatsEntity flat = new FlatsEntity() ;
                flat.setFlatNumber(i);
                flat.setBuildsEntity(build);
                services.addFlat(flat);
            }
        }

        model.addAttribute("users", services.listUsers(null));
        return "main/userslist";
    }

    @RequestMapping("/signup/addUser2")
    public String addUserInfo(@RequestParam String name, @RequestParam String lastName, @RequestParam String secondName,
                              @RequestParam String phone, @RequestParam long flatNum, @ModelAttribute("user") UserEntity user, Model model) {
        UserInfoEntity userIE;
        FlatsEntity  flat = services.getFlatById(flatNum);
        String[] list = {name, lastName, secondName, phone};
        for (String s : list) {
            if((s == null)||(s.isEmpty()))
                return "errors/403_Error";
        }
        if(flat == null)
            return "errors/403_Error";

        userIE = new UserInfoEntity(lastName,name,  secondName, phone,user, flat);
        model.addAttribute("userIE", userIE);
        services.addUserInfo(userIE);
        return "regist/user/success";
    }

    @RequestMapping("/signup/gotoFlat")
    public String addFlat(Model model) {
        return "regist/user/signup2Flat";
    }


    @RequestMapping("/signup/addFlat")
    public String addFlat(@RequestParam int peopleCount, @RequestParam BigDecimal area, @ModelAttribute("user") UserEntity user,
                          @ModelAttribute("userIE") UserInfoEntity userIE, Model model) {
        if(peopleCount == 0)
            return "errors/403_Error";
        FlatsEntity flat = userIE.getFlatsEntity();
        flat.setBuildsEntity(user.getBuildsEntity());
        flat.setPeopleCnt(peopleCount);
        flat.setArea(area);
        services.mergeFlat(flat);
        return "main/mainuser";
    }


    //войти
    @RequestMapping ("/signin")
    public String signin (@RequestParam String login,@RequestParam String pass,Model model)
    {
        UserEntity user = services.getUserByLogin(login);
         if (user.getPass().equals(pass)){
            model.addAttribute("user",user);
            List<UserEntity> listUsers = services.listUsers(user.getBuildsEntity());
            List<User> listUser = new ArrayList<>();
             for(UserEntity u : listUsers){
                User us = new User(u);
                listUser.add(us);
            }
            model.addAttribute("users",listUser);
            return "main/mainuser";
        }
        else return "hello/signIN";
    }

    @RequestMapping("/inviteusers")
    public String inviteUsers (@RequestParam String email,Model model)
    {

        new  Email().sendMail(email);
        return "main/mainuser";
    }

    @RequestMapping("/test")
    public String inviteUsers (Model model)
    {

        model.addAttribute("test","");
        model.addAttribute("test2","");
        return "test";
    }


}
