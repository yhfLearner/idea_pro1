package com.hwua.controller;

import com.hwua.util.CodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ValidateCodeController {
    private List<String> words;

    public void init(HttpServletRequest request) throws ServletException {
        words = new ArrayList<>();
        String path = request.getServletContext().getRealPath("/WEB-INF/words.txt");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line = null;

            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/validateCode")
    public void dateCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init(request);
        Map<String, Object> map = CodeUtil.code(120, 30, 30, words);
        String code = (String) map.get("code");//得到验证码
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        //告知客户端浏览器,生成的是图片
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();//字节输出流
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", out);
        out.close();
    }
}
