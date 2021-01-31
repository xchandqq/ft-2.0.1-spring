/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xchandqq.ft.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Christian
 */
@Controller
public class ViewController {
    
    @GetMapping("/login")
    public String loginPage(HttpServletRequest req,Model model){
        String isError = req.getParameter("error");
        if(isError != null) model.addAttribute("error", true);
        return "login";
    }
    
    @RequestMapping(value = "/home")
    public String homePage(Model model){
        Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        return "home";
    }
}
