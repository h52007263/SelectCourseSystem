package com.hzs.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 消息实体类
 * @date 2019/6/4 14:19
 */

@Entity
@Table(name = "message")
public class Message {
    private int messageId;  //消息id
    private String courseName;  //课程名称
    private String detail;  //消息详细描述
    private Date time;  //消息时间

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Column(name = "couseName",length = 20)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "detail",length = 100)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Message() {
    }

    public Message(String courseName, String detail, Date time) {
        this.courseName = courseName;
        this.detail = detail;
        this.time = time;
    }

    public Message(int messageId, String courseName, String detail, Date time) {
        this.messageId = messageId;
        this.courseName = courseName;
        this.detail = detail;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", courseName='" + courseName + '\'' +
                ", detail='" + detail + '\'' +
                ", time=" + time +
                '}';
    }
}
