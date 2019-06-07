package com.hzs.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author hezhensheng
 * @version 1.0
 * @description
 * @date 2019/5/29 20:49
 */
@Entity
@Table(name = "course_plan")
public class CoursePlan {
    private int courseplanId;
    private Integer weight;
    private Integer section;

    //课程计划   一对一  课程
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Id
    @GenericGenerator(name = "id",strategy = "assigned")
    @GeneratedValue(generator = "id")
    @Column(name = "courseplan_id")
    public int getCourseplanId() {
        return courseplanId;
    }

    public void setCourseplanId(int courseplanId) {
        this.courseplanId = courseplanId;
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

    public CoursePlan() {
    }

    public CoursePlan(Integer weight, Integer section) {
        this.weight = weight;
        this.section = section;
    }

    public CoursePlan(int courseplanId, Integer weight, Integer section) {
        this.courseplanId = courseplanId;
        this.weight = weight;
        this.section = section;
    }

    @Override
    public String toString() {
        return "CoursePlan{" +
                "courseplanId=" + courseplanId +
                ", weight=" + weight +
                ", section=" + section +
                '}';
    }
}
