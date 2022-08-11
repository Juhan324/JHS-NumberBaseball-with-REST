package com.jhs.numberbaseball.controller;

import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhs.numberbaseball.service.LoginService;
import com.jhs.numberbaseball.vo.UserVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;
    private final SessionRegistry sessionRegistry;

    @GetMapping
    public String root(Model model) {
        model.addAttribute("loginedUser", sessionRegistry.getAllPrincipals().stream().map(o->((User)o).getUsername()).toArray());
        return "lobby";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/signUp")
    public String SignUp() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(UserVO user){
        loginService.joinUser(user);
        return "login";
    }

    @PostMapping("/success")
    public String success() {
        return "redirect:/";
    }

    @GetMapping("/access_denied")
    public String accessDenied() { 
        return "access_denied";
    }
}
