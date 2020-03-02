package com.hwua.controller;

import com.hwua.entity.User;
import com.hwua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginRegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
//    @ResponseBody
    public Map<String, Object> login(User user, @RequestParam("code") String code, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<>();
        //先比较验证码
        String vcode = (String) session.getAttribute("code");//从session取出验证码
        session.removeAttribute("code");//取出验证码就失效,只能用一次
        //比对验证码
        if (vcode == null || !vcode.equals(code)) {
            map.put("success", false);
            map.put("info", "验证码出错");
        } else {

                user = userService.login(user);
                if (user != null) {
                    session.setAttribute("user", user);//登录成功,把当前用户存入session
                    map.put("success", true);
                    map.put("info", "");
                } else {
                    map.put("success", false);
                    map.put("info", "用户名密码出错!");

            }
        }

        return map;
    }
}
