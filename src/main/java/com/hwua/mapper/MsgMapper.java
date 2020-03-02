package com.hwua.mapper;

import com.hwua.entity.Message;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MsgMapper {
    public List<Message> queryAll(Long id) throws Exception;

    public int delete(Long id) throws Exception;

    public Message query(Long id) throws Exception;

    public int update(Message msg) throws Exception;

    public int save(Message msg) throws Exception;

    //分页查询语句
    public List<Message> queryAllByReceiveId(Long receiveid) throws Exception;


}
