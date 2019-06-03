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
@Table(name = "classroom")
public class Classroom {
    private int classroomId;
    private String name;
    private Integer capacity;

    @Id
    @GenericGenerator(name = "id",strategy = "assigned")
    @GeneratedValue(generator = "id")
    @Column(name = "classroom_id")
    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    @Column(name = "name",length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Classroom() {
    }

    public Classroom(int classroomId, String name, Integer capacity) {
        this.classroomId = classroomId;
        this.name = name;
        this.capacity = capacity;
    }

    public Classroom(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId=" + classroomId +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
