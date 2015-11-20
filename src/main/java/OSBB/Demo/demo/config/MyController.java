package OSBB.Demo.demo.config;

import OSBB.Demo.demo.entity.User;
import OSBB.Demo.demo.services.UserDetailServiceImpl;
import OSBB.Demo.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MyController {
    static final int DEFAULT_GROUP_ID = -1;

//    @Autowired
//    private ContactService contactService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(@RequestParam String user_login,
                         @RequestParam String user_password,
                         @RequestParam String user_email) {
        User user = new User();
        user.setUser_login(user_login);
        user.setUser_password(user_password);
        user.setUser_email(user_email);
        userService.addUser(user);

        return "index";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }
}

   /* @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("groups", contactService.listGroups());
        model.addAttribute("contacts", contactService.listContacts(null));
        return "index";
    }

    @RequestMapping("/contact_add_page")
    public String contactAddPage(Model model) {
        model.addAttribute("groups", contactService.listGroups());
        return "contact_add_page";
    }

    @RequestMapping("/group_add_page")
    public String groupAddPage() {
        return "group_add_page";
    }

    @RequestMapping("/group/{id}")
    public String listGroup(@PathVariable(value = "id") long groupId, Model model) {
        Group group = (groupId != DEFAULT_GROUP_ID) ? contactService.findGroup(groupId) : null;

        model.addAttribute("groups", contactService.listGroups());
        model.addAttribute("currentGroup", group);
        model.addAttribute("contacts", contactService.listContacts(group));
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam String pattern, Model model) {
        model.addAttribute("groups", contactService.listGroups());
        model.addAttribute("contacts", contactService.searchContacts(pattern));
        return "index";
    }

    @RequestMapping(value = "/contact/delete", method = RequestMethod.POST)
    public String search(@RequestParam(value = "toDelete[]", required = false) long[] toDelete, Model model) {
        if (toDelete != null)
            contactService.deleteContact(toDelete);

        model.addAttribute("groups", contactService.listGroups());
        model.addAttribute("contacts", contactService.listContacts(null));
        return "index";
    }

    @RequestMapping(value = "/contact/add", method = RequestMethod.POST)
    public String contactAdd(@RequestParam(value = "group") long groupId,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String phone,
                             @RequestParam String email,
                             Model model) {
        Group group = (groupId != DEFAULT_GROUP_ID) ? contactService.findGroup(groupId) : null;

        Contact contact = new Contact(group, name, surname, phone, email);
        contactService.addContact(contact);

        model.addAttribute("groups", contactService.listGroups());
        model.addAttribute("contacts", contactService.listContacts(null));
        return "index";
    }

    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    public String groupAdd(@RequestParam String name, Model model) {
        contactService.addGroup(new Group(name));

        model.addAttribute("groups", contactService.listGroups());
        model.addAttribute("contacts", contactService.listContacts(null));
        return "index";
    }
}*/
