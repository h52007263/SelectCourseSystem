package com.hzs.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description CourseWish 排课意向表
 * @date 2019/6/5 18:04
 */
@Entity
@Table(name = "course_wish")
public class CourseWish {
    private Integer courseId;
    private String courseName;
    //排课的意向条件
    private Integer weight;     //课程权重
    private Integer section;    //课程节数
    private Integer joins;       //是否连堂
    private Integer ampm;       //期望上/下午

    @Id
    @GenericGenerator(name = "id",strategy = "assigned")
    @GeneratedValue(generator = "id")
    @Column(name = "course_id")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Column(name = "course_name",length = 20)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "section")
    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    @Column(name = "joins")
    public Integer getJoins() {
        return joins;
    }

    public void setJoins(Integer joins) {
        this.joins = joins;
    }

    @Column(name = "ampm")
    public Integer getAmpm() {
        return ampm;
    }

    public void setAmpm(Integer ampm) {
        this.ampm = ampm;
    }

    public CourseWish() {
    }

    public CourseWish(Integer courseId, String courseName, Integer weight, Integer section, Integer joins, Integer ampm) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.weight = weight;
        this.section = section;
        this.joins = joins;
        this.ampm = ampm;
    }

    @Override
    public String toString() {
        return "CourseWith{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", weight=" + weight +
                ", section=" + section +
                ", joins=" + joins +
                ", ampm=" + ampm +
                '}';
    }
}
