package com.hzs.model;
import com.hzs.dao.impl.CourseDaoImpl;

import javax.persistence.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description
 * @date 2019/5/29 20:49
 */
@Entity
@Table(name="course")
public class Course {
    private int courseId;
    private String courseName;
    private String courseProperty;
    private Integer courseHour;
    private Integer courseCredit;
    private Integer capacity;
    private Integer grade;
    private String major;

    //课程  多对一  教师
    private Teacher teacher;

    //课程 一对一  课程计划
    private CoursePlan coursePlan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL)
    public CoursePlan getCoursePlan() {
        return coursePlan;
    }

    public void setCoursePlan(CoursePlan coursePlan) {
        this.coursePlan = coursePlan;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Column(name = "course_name", length = 20)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "course_property", length = 20)
    public String getCourseProperty() {
        return courseProperty;
    }

    public void setCourseProperty(String courseProperty) {
        this.courseProperty = courseProperty;
    }

    @Column(name = "course_hour")
    public Integer getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(Integer courseHour) {
        this.courseHour = courseHour;
    }

    @Column(name = "course_credit")
    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Column(name = "grade")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Column(name = "major",length = 20)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Course() {
    }

    public Course(int courseId, String courseName, String courseProperty, Integer courseHour, Integer courseCredit,
                  Integer capacity, Integer grade, String major, Teacher teacher, CoursePlan coursePlan) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseProperty = courseProperty;
        this.courseHour = courseHour;
        this.courseCredit = courseCredit;
        this.capacity = capacity;
        this.grade = grade;
        this.major = major;
        this.teacher = teacher;
        this.coursePlan = coursePlan;
    }

    public Course(int courseId, String courseName, String courseProperty, Integer courseHour,
                  Integer courseCredit, Integer capacity, Integer grade, String major) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseProperty = courseProperty;
        this.courseHour = courseHour;
        this.courseCredit = courseCredit;
        this.capacity = capacity;
        this.grade = grade;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseProperty='" + courseProperty + '\'' +
                ", courseHour=" + courseHour +
                ", courseCredit=" + courseCredit +
                ", capacity=" + capacity +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                ", teacher=" + teacher +
                ", coursePlan=" + coursePlan +
                '}';
    }
}
