package com.example.restapiclasswork.Controller;

import com.example.restapiclasswork.DTO.UserDTO;
import com.example.restapiclasswork.Model.User;
import com.example.restapiclasswork.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/view-all-users")
    public List<User> allUsers(){
        return userService.findAll();
    }

    @PutMapping("/update{id}")
    public User updateUser(@PathVariable ("id")Long id,@RequestBody UserDTO userDTO) {
        return userService.updateUser(id,userDTO);
    }

    @DeleteMapping("/delete{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "User with id: "+id+ " successfully deleted";
    }

    @GetMapping("/login")
    public User findById(@RequestBody UserDTO userDTO, HttpServletRequest httpServletRequest){
        User user = userService.loginUser(userDTO);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("id", user.getId());
        return user;
    }
}
