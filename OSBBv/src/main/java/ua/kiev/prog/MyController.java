package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

import java.math.BigDecimal;

@Controller
@RequestMapping("/")
@SessionAttributes( types = {BuildsEntity.class, UserEntity.class, UserInfoEntity.class})
@PreAuthorize("hasRole('ADMIN')")
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
      /*  BuildsEntity build;

        String[] list = {login, pass, email};
        for (String s : list) {
            if((s == null)||(s.isEmpty()))
                return "403_Error";
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
        }*/

      //  services.addUser(user);
        return group == USER_TYPE ? "signup2User" : "signup2Admin";
    }


    @RequestMapping("/signup/addAdmin2")
    public String addBuild(@RequestParam Short flatCnt, @RequestParam String city, @RequestParam String street,
                           @RequestParam String buildNum, @ModelAttribute("build") BuildsEntity build, Model model) {
        build.setBuildNum(buildNum);
       // services.mergeBuild(build);
        if ( build.getId()!=0 ){
            for (int i = 1; i <= build.getFlatCnt(); i++) {
               FlatsEntity flat = new FlatsEntity() ;
                flat.setFlatNumber(i);
                flat.setBuildsEntity(build);
              //  services.addFlat(flat);
            }
        }
     //   model.addAttribute("users", services.list(null));
        return "userlist";
    }

    @RequestMapping("/signup/addUser2")
    public String addUserInfo(@RequestParam String name, @RequestParam String lastName, @RequestParam String secondName,
                              @RequestParam String phone, @RequestParam long flatNum, @ModelAttribute("user") UserEntity user, Model model) {
        UserInfoEntity userIE;
        //FlatsEntity  flat = services.getFlatById(flatNum);
        String[] list = {name, lastName, secondName, phone};
        for (String s : list) {
            if((s == null)||(s.isEmpty()))
                return "403_Error";
        }


      //  userIE = new UserInfoEntity(name, lastName, secondName, phone,user, flat);
      //  model.addAttribute("userIE", userIE);
       // services.addUserInfo(userIE);
        return "success";
    }

    @RequestMapping("/signup/gotoFlat")
    public String addFlat(Model model) {
        return "signup2Flat";
    }


    @RequestMapping("/signup/addFlat")
    public String addFlat(@RequestParam int peopleCount, @RequestParam BigDecimal area, @ModelAttribute("user") UserEntity user,
                          @ModelAttribute("userIE") UserInfoEntity userIE, Model model) {
        if(peopleCount == 0)
            return "403_Error";
        FlatsEntity flat = userIE.getFlatsEntity();
        flat.setBuildsEntity(user.getBuildsEntity());
        flat.setPeopleCnt(peopleCount);
        flat.setArea(area);
      //  services.mergeFlat(flat);
        return "endOfRegUser";
    }
}
