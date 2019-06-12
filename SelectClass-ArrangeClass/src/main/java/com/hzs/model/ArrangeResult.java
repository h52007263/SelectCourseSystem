package com.hzs.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author hezhensheng
 * @version 1.0
 * @description ArrangeResult
 * @date 2019/6/6 20:10
 */

@Entity
@Table(name = "arrange_result")
public class ArrangeResult implements Serializable {
    private String courseName;
    private String useTime; //使用时间
    private String roomName;   //教室名称
    private String major;   //专业
    private int grade;  //年级
    private String teacherName;

    @Column(name = "course_name",length = 20)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Id
    @GenericGenerator(name = "use_time",strategy = "assigned")
    @GeneratedValue(generator = "use_time")
    @Column(name = "use_time",length = 10)
    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    @Id
    @GenericGenerator(name = "room_name",strategy = "assigned")
    @GeneratedValue(generator = "room_name")
    @Column(name = "room_name",length = 10)
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Id
    @GenericGenerator(name = "major",strategy = "assigned")
    @GeneratedValue(generator = "major")
    @Column(name = "major",length = 20)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Column(name = "grade")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Column(name = "teacher_name",length = 20)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public ArrangeResult() {
    }

    public ArrangeResult(String courseName, String useTime, String roomName, String major, int grade, String teacherName) {
        this.courseName = courseName;
        this.useTime = useTime;
        this.roomName = roomName;
        this.major = major;
        this.grade = grade;
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "ArrangeResult{" +
                "courseName='" + courseName + '\'' +
                ", useTime='" + useTime + '\'' +
                ", roomName='" + roomName + '\'' +
                ", major='" + major + '\'' +
                ", grade=" + grade +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
