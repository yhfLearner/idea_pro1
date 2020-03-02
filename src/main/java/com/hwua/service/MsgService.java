package com.hwua.service;

import com.hwua.entity.Message;

import java.util.List;

public interface MsgService {
    //查询当前登录用户收到的所有短消息
    public List<Message> findAllMsgsById(Long id) throws Exception;

    public int delMessageById(Long id) throws Exception;

    public Message queryMsgById(Long id) throws Exception;

    public int sendMsg(Message msg) throws Exception;

    public List<Message> findMessagesByLimit(Long receiveId) throws Exception;


}
