package com.hzs.util.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 课程条件实体类
 * @date 2019/6/1 21:47
 */

public class CourseCondition {

    private Integer courseId;
    private String courseName;
    //排课的意向条件
    private Integer weight;     //课程权重
    private Integer section;    //课程节数
    private Integer join;       //是否连堂
    private Integer ampm;       //期望上/下午
    private Integer day;        //期望周几
    private Integer time;       //上课时间

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public CourseCondition() {
    }

    public CourseCondition(Integer courseId, String courseName, Integer weight, Integer section, Integer join, Integer ampm, Integer day) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.weight = weight;
        this.section = section;
        this.join = join;
        this.ampm = ampm;
        this.day = day;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getJoin() {
        return join;
    }

    public void setJoin(Integer join) {
        this.join = join;
    }

    public Integer getAmpm() {
        return ampm;
    }

    public void setAmpm(Integer ampm) {
        this.ampm = ampm;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "CourseCondition{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", weight=" + weight +
                ", section=" + section +
                ", join=" + join +
                ", ampm=" + ampm +
                ", day=" + day +
                '}';
    }
}
