package dimMo.controller;

import dimMo.model.User;
import dimMo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService usersService) {
        this.userService = usersService;
    }


    @RequestMapping(value = "/")
    public String getAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all_users";
    }

    @GetMapping("/creat_user")
    public String getCreatUser(Model model) {
        model.addAttribute("user", new User());
        return "creat_user";
    }

    @PostMapping("/creat_user")
    public String getAddUser(@ModelAttribute("user") User user1) {
        userService.addUser(user1);
        return "redirect:/";
    }

    @GetMapping("/update_user")
    public String getWhatUpdateUser(Model model) {
        model.addAttribute("userU", new User());
        return "update_user";
    }

    @PostMapping("/update_user")
    public String getUpdateUser(@ModelAttribute("userU") User user) {
        try {
            userService.updateUser(user.getId(), user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/delete_user")
    public String getWhatDeleteUser(Model model) {
        model.addAttribute("userD", new User());
        return "delete_user";
    }

    @PostMapping("/delete_user")
    public String getDeleteUser(@ModelAttribute("userD") User user) {
        try {
            userService.deleteUser(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
