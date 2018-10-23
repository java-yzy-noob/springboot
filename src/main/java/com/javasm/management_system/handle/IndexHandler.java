package com.javasm.management_system.handle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ih")
public class IndexHandler {

    @RequestMapping("/login")
    public String login(){

        System.out.println("login---------");
        return "first/login";
    }

    @RequestMapping("/goIndex")
    public String goIndex(String username, String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (username != null && !"".equals(username)){
            session.setAttribute("username", username);
        }
        return "first/index";
    }

    @RequestMapping("/showHelp")
    public String showHelp(){
        return "first/help";
    }

}
