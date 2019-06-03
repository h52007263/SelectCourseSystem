package com.hzs.model;

import java.util.Objects;

/**
 * @author hezhensheng
 * @version 1.0
 * @description
 * @date 2019/5/29 20:49
 */
public class TimeTable {
    private int timetableId;
    private String courseName;
    private String teacherName;
    private String classroomName;
    private Integer week;

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeTable timeTable = (TimeTable) o;
        return timetableId == timeTable.timetableId &&
                Objects.equals(courseName, timeTable.courseName) &&
                Objects.equals(teacherName, timeTable.teacherName) &&
                Objects.equals(classroomName, timeTable.classroomName) &&
                Objects.equals(week, timeTable.week);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timetableId, courseName, teacherName, classroomName, week);
    }
}
