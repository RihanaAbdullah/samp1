package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
private final LoginService loginservice;
public LoginController(LoginService loginservice){
    this.loginservice=loginservice;
}
@GetMapping("/")
public String login(){
    return "login";
}

@PostMapping("/")
public String login(@RequestParam String username,@RequestParam String password,Model model){
    if(loginservice.authenticate(username,password)){
        return "redirect:/welcome";
    }
    model.addAttribute("Error");
    return "login";
}

@GetMapping("/welcome")
public String welcome(){
    return "welcome";
}

}
