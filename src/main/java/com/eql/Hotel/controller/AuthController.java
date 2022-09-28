package com.eql.Hotel.controller;

import com.eql.Hotel.dto.UserDto;
import com.eql.Hotel.models.User;
import com.eql.Hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    UserService userService;


    @GetMapping("/index")
    public String home(@AuthenticationPrincipal UserDetails UserPrincipal, Model model){

        if (UserPrincipal != null){
            User user = userService.findUserByEmail(UserPrincipal.getUsername());
            UserDto userDto = userService.mappingUser(user);
            System.out.println(userDto.toString());
            model.addAttribute("connectedUser",userDto);
        }

        return "index";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model){

        UserDto userDto = new UserDto();
        model.addAttribute("user" , userDto);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration (@Valid @ModelAttribute("UserDto") UserDto userDto,
                                BindingResult result,                      // binding result sert à stocké des erreurs
                                Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null && existingUser.getEmail() !=null ){
           result.rejectValue("email", null, "Email already used");

        } // Ici on garde en mémoires les informations de l'utilisateur
        if (result.hasErrors()){
            model.addAttribute("UserDto" , userDto);
                    return "/register";
        }
        userService.saveUser(userDto);
        return "redirect:/login?success";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("UserDto", users);
        return "users";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

}
