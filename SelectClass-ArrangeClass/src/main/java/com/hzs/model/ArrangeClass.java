package com.hzs.model;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

/**
 * @author hezhensheng
 * @version 1.0
 * @description
 * @date 2019/5/29 20:49
 */
public class ArrangeClass {
    private int classroomId;
    private String useTime;
    private Integer weeks;

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrangeClass that = (ArrangeClass) o;
        return classroomId == that.classroomId &&
                Objects.equals(useTime, that.useTime) &&
                Objects.equals(weeks, that.weeks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classroomId, useTime, weeks);
    }
}
