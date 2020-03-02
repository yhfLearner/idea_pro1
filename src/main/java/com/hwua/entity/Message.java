package com.hwua.entity;

import java.text.SimpleDateFormat;

public class Message {
    private long id;
    private long sendid;
    private String title;
    private String msgcontent;
    private long state;
    private long receiveid;
    private String msgCreateDate;
    private User sendUser = null;// 短信发送者1对1的关系

    public User getSendUser() {
        return sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }

    public Message() {

    }

    public Message(long sendid, String title, String msgcontent, long state, long receiveid, String msgCreateDate) {
        this.sendid = sendid;
        this.title = title;
        this.msgcontent = msgcontent;
        this.state = state;
        this.receiveid = receiveid;
        this.msgCreateDate = msgCreateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getSendid() {
        return sendid;
    }

    public void setSendid(long sendid) {
        this.sendid = sendid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent;
    }


    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }


    public long getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(long receiveid) {
        this.receiveid = receiveid;
    }


    public String getMsgCreateDate() {
        return msgCreateDate;
    }

    public void setMsgCreateDate(String msgCreateDate) {
        this.msgCreateDate = msgCreateDate;
    }

}
