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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@SessionAttributes( value = {"build", "user"},types = {BuildsEntity.class, UserEntity.class})
public class MyController {

    static final int USER_TYPE = 0;
    static final int ADMIN_TYPE = 1;

    @Autowired
    private Services services;


    /////--------------------Всеволод
    @RequestMapping("/")
    public String index(Model model) {
         //services.addUser(new UserEntity());
        return "hello/signIN";
    }

    @RequestMapping("/signup")
    public String loginSecur(Model model) {
        return "hello/signIN";
    }

    @RequestMapping("/errors/403_Error")
    public String error(Model model) {
        return "errors/403_Error";
    }

    /*@RequestMapping("/signup")
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
            model.addAttribute("listFlat",services.listFlat(build));
        } else if (group == ADMIN_TYPE) {
            build = new BuildsEntity(null);
            services.addBuild(build);
            user = new UserEntity(login, pass, email, group, build);
                model.addAttribute("build", build);
        }
        services.addUser(user);
        user = services.mergeUser(user);
        model.addAttribute("user", user);
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
        model.addAttribute("services", services.listServices());
            return "regist/admin/addService";
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
        user.setUserInfo(userIE);
        model.addAttribute("userIE", userIE);
        services.addUserInfo(userIE);
        return "regist/user/success";
    }

    @RequestMapping("/signup/gotoFlat")
    public String addFlat(Model model) {
        return "regist/user/signup2Flat";
    }



    @RequestMapping("/signup/addFlat")
    public String addFlat(@RequestParam int peopleCount, @RequestParam BigDecimal area, @ModelAttribute("user") UserEntity user, Model model) {
        if (peopleCount == 0)
            return "errors/403_Error";

        UserInfoEntity userIE = user.getUserInfo();
        if (userIE == null)
            return "errors/403_Error";

        FlatsEntity flat = userIE.getFlatsEntity();
        flat.setBuildsEntity(user.getBuildsEntity());
        flat.setPeopleCnt(peopleCount);
        flat.setArea(area);
        services.mergeFlat(flat);
        return "main/user/mainuser";
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
            model.addAttribute("user",user);
            model.addAttribute("users",listUser);
            return user.getType()==USER_TYPE ? "main/user/mainuser" : "main/admin/mainadmin";
        }
        else return "hello/signIN";
    }

    @RequestMapping("/inviteusers")
    public String inviteUsers (@RequestParam String email,@ModelAttribute("user") UserEntity user,Model model)
    {
        String code = user.getBuildsEntity().getCode();
            new Email().sendMail(email,code);
           return user.getType()== USER_TYPE ? "main/user/mainuser" : "main/admin/mainadmin";
    }


    @RequestMapping("/admin/add/service")
    public String addService (@RequestParam Map<String,String> allRequestParams,@ModelAttribute("user") UserEntity user,Model model)
    {
        BuildsEntity build = user.getBuildsEntity();
        for (Map.Entry<String, String> entry : allRequestParams.entrySet())
        {
            BuildServices buildServ = new BuildServices();
            buildServ.setRate(Integer.parseInt(entry.getValue()));
            buildServ.setBuildsEntity(build);
            buildServ.setServicesEntity(services.geterviceById(Integer.parseInt(entry.getKey())));
            services.addBuildServices(buildServ);
        }
        user = services.mergeUser(user);
        return "main/admin/mainadmin";
    }*/


    @RequestMapping("/test")
    public String inviteUsers (Model model)
    {

       // services.findOneUserByLogin("admin");
         model.addAttribute("admin",services.findOneUserByLogin("admin"));
        return "test2";
    }

    @RequestMapping("/hello/signINincorrect")
    public String incorrectLogin (Model model)
    {
        return "/hello/signINincorrect";
    }

    @RequestMapping("/test2")
    public String inviteUsers2(Model model)
    {
       BuildsEntity build =  services.findBuildByID((long) 1);
       UserEntity user = services.findOneUsersByBuild(build);
        //services.listServices();
         model.addAttribute("user", user);
        return "testdata";
    }

}
