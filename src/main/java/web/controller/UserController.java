package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUserAll(Model model){
        //Получаем всех пользователей из UserService и передаем на отображение.
        model.addAttribute("users",userService.getUserAll());
        return "users";
    }

    @GetMapping("/{index}")
    public String getUserIndex(@PathVariable("index") int index, Model model) {
        model.addAttribute("person",userService.getUserIndex(index));
        return "person";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{index}/update")
    public String updateUser(Model model,@PathVariable("index") int id){
        model.addAttribute("user",userService.getUserIndex(id));
        return "/update";
    }

    @PostMapping("/{index}")
    public String update(@ModelAttribute("user") User user,@PathVariable("index") int id){
        userService.updateUser(id,user);
        return "redirect:/";
    }

    @DeleteMapping("/{index}")
    public String delete(@PathVariable("index") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }


}
