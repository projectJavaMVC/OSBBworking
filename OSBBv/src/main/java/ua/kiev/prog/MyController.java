package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.services.Services;
import ua.kiev.prog.entity.UserEntity;

@Controller
@RequestMapping("/")
@SessionAttributes (names = "build", types = BuildsEntity.class)
public class MyController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int USER_TYPE=0;
    static final int ADMIN_TYPE=1;

    @Autowired
    private Services services;


   /////--------------------Всеволод
    @RequestMapping("/")
     public String index(Model model) {
        return "signup";
    }



    @RequestMapping("/signup/add")
    public String addUser(@RequestParam String login,@RequestParam String pass,@RequestParam String email,@RequestParam Short group,@RequestParam String key,Model model) {
        UserEntity us=null;
        BuildsEntity build;

        if (group==USER_TYPE)
        {
            build = services.getBuildByKey(key);
            us = new UserEntity(login,pass,email,group,build);

        }
        else if (group==ADMIN_TYPE)
        {
            build = new BuildsEntity(null);
            services.addBuild(build);
            us=new UserEntity(login,pass,email,group,build);
            model.addAttribute("build",build);
        }
        services.addUser(us);
        return group==USER_TYPE ? "signup2User" : "signup2Admin";
    }

    @RequestMapping("/signup/addAdmin2")
    public String addBuild(@RequestParam Short flatCnt,@RequestParam String city,@RequestParam String street,@RequestParam String buildNum,@ModelAttribute("build") BuildsEntity build,Model model) {
        build.setBuildNum(buildNum);
        services.mergeBuild(build);
        model.addAttribute("users",services.list(null));
        return "userlist";

    }


}
