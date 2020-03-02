package com.hwua.controller;

import com.hwua.entity.User;
import com.hwua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user.do")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();//销毁当前session
        }
        return "index";
    }

    @RequestMapping("/queryAllUsers/{sendid}")
    public String queryAllUsers(@PathVariable("sendid") String sendid, Model model) {
        try {
            List<User> uList = userService.getAllUsers();
            //代表是回复短消息,而不是发送短消息
            if (sendid != null) {
                model.addAttribute("sendid", sendid);//保存发送者的id
            }
            model.addAttribute("users", uList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/newMsg.jsp";
    }
}
