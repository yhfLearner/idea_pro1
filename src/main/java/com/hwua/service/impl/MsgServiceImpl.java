package com.hwua.service.impl;

import com.hwua.entity.Message;
import com.hwua.entity.User;
import com.hwua.mapper.MsgMapper;
import com.hwua.mapper.UserMapper;
import com.hwua.service.MsgService;
/*import com.hwua.util.SqlSessionFactoryUtil;*/
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("msgService")
public class MsgServiceImpl implements MsgService {
    @Autowired
    private MsgMapper msgMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Message> findAllMsgsById(Long id) throws Exception {

        return msgMapper.queryAll(id);
    }


    @Override
    public int delMessageById(Long id) throws Exception {

        return msgMapper.delete(id);


    }

    @Override
    public Message queryMsgById(Long id) throws Exception {
        Message msg = msgMapper.query(id);
        if (msg.getState() == 1) {
            msg.setState(0);
            msgMapper.update(msg);//更新
        }
        //根据发送者的id来查询得到发送者的User对象
        long sendid = msg.getSendid();
        User sendUser = userMapper.queryById(sendid);
        msg.setSendUser(sendUser);//绑定发送者的信息
        return msg;

    }

    @Override
    public int sendMsg(Message msg) throws Exception {
        return msgMapper.save(msg);
    }

    @Override
    public List<Message> findMessagesByLimit(Long receiveId) throws Exception {
        return msgMapper.queryAllByReceiveId(receiveId);

    }

}
