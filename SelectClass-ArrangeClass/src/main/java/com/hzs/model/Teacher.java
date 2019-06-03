package com.hzs.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author hezhensheng
 * @version 1.0
 * @description
 * @date 2019/5/29 20:49
 */

@Entity
@Table(name = "teacher")
public class Teacher {
    private int teacherId;
    private String name;
    private Integer age;
    private String gender;
    private String password;
    private String telphone;
    //教师 一对多 课程
    private Set<Course> courses=new HashSet<>();

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Id
    @GenericGenerator(name = "id", strategy = "assigned")
    @GeneratedValue(generator = "id")
    @Column(name = "teacher_id")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "gender",length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "password",length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "telphone",length = 11)
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Teacher() {
    }

    public Teacher(int teacherId, String name, Integer age, String gender, String password, String telphone) {
        this.teacherId = teacherId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.telphone = telphone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", telphone='" + telphone + '\'' +
                '}';
    }
}
