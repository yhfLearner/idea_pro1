package com.hwua.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.entity.Message;
import com.hwua.entity.User;
import com.hwua.service.MsgService;
import com.hwua.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/msg.do")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @RequestMapping("/queryAll")
    public String queryAll(@SessionAttribute("user") User user, Model model) throws Exception {
        Long id = user.getId();

        //调用业务层的方法
        List<Message> msgList = msgService.findAllMsgsById(id);
        //把数据放到域中
        model.addAttribute("msgList", msgList);

        return "forward:/main.jsp";
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Long id) {
        try {
            int res = msgService.delMessageById(id);
            if (res > 0) {
                return "redirect:/msg.do/queryAll";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/queryMsgById/{id}")
    public String queryMsgById(@PathVariable("id") Long id, Model model) {
        Message message = null;
        try {
            message = msgService.queryMsgById(id);
            model.addAttribute("msg", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/readMsg.jsp";

    }

    @RequestMapping("/sendMsg")
    public String sendMsg(@SessionAttribute("user") User user, @RequestParam("toUser") Long receiveId, @RequestParam("title") String title, @RequestParam("content") String msgContent) {
        Long loginUserid = user.getId();//登陆者的id,也是发送者的id
        int state = 1;
        String msgCreateDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //封装成Message对象
        Message msg = new Message(loginUserid, title, msgContent, state, receiveId, msgCreateDate);
        try {
            int res = msgService.sendMsg(msg);
            if (res > 0) {
                return "forward:/main.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/showMsgs/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Message> showMsgs(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize, @SessionAttribute("user") User user) throws Exception {
        Long receiveid = 0L;
        if (user != null) {
            receiveid = user.getId();//登录的id,也是接收短消息的id
        }
        PageHelper.startPage(pageNo, pageSize);
        List<Message> msgList = msgService.findMessagesByLimit(receiveid);
        PageInfo<Message> pageEntity = new PageInfo<>(msgList);
        return pageEntity;


    }
}
