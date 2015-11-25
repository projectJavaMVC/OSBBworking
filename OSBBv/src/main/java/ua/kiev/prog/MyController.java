package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.kiev.prog.entity.BuildsEntity;
import ua.kiev.prog.entity.FlatsEntity;
import ua.kiev.prog.entity.UserEntity;
import ua.kiev.prog.entity.UserInfoEntity;
import ua.kiev.prog.services.Services;

@Controller
@RequestMapping("/")
@SessionAttributes(names = {"build", "user"}, types = {BuildsEntity.class, UserEntity.class})
public class MyController {

    static final int USER_TYPE = 0;
    static final int ADMIN_TYPE = 1;

    @Autowired
    private Services services;


    /////--------------------Всеволод
    @RequestMapping("/")
    public String index(Model model) {
        return "signIN";
    }


    @RequestMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }


    @RequestMapping("/signup/add")
    public String addUser(@RequestParam String login, @RequestParam String pass, @RequestParam String email,
                          @RequestParam Short group, @RequestParam String key, Model model) {
        BuildsEntity build;

        if ((login == null) || (login.isEmpty()))
            return "403_Error";
        if ((pass == null) || (pass.isEmpty()))
            return "403_Error";
        if ((email == null) || (email.isEmpty()))
            return "403_Error";

        UserEntity user = new UserEntity();
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
        return group == USER_TYPE ? "signup2User" : "signup2Admin";
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
       // model.addAttribute("users", services.list(null));
        return "signupadmin3";
    }

    @RequestMapping("/signup/addUser2")
    public String addUserInfo(@RequestParam String name, @RequestParam String lastName, @RequestParam String secondName,
                              @RequestParam String phone, @RequestParam String flatNum, @ModelAttribute("user") UserEntity user, Model model) {
        UserInfoEntity userIE;
        if ((name == null) || (name.isEmpty()))
            return "403_Error";
        if ((phone == null) || (phone.isEmpty()))
            return "403_Error";
        if ((secondName == null) || (secondName.isEmpty()))
            return "403_Error";
        if ((lastName == null) || (lastName.isEmpty()))
            return "403_Error";
        if ((flatNum == null) || (flatNum.isEmpty()))
            return "403_Error";

        //userIE = new UserInfoEntity(name, lastName, secondName, phone, flatNum, user);
        //services.addUserInfo(userIE);
        return "success";
    }
}
