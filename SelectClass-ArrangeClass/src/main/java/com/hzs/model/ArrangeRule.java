package com.hzs.model;

import javax.persistence.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 排课规则实体类
 * @date 2019/6/3 18:37
 */

@Entity
@Table(name = "arrange_rule")
public class ArrangeRule {
    private Integer ruleId;
    private String name;
    private Integer pointNum;
    private String content;

    public ArrangeRule() {
    }

    @Override
    public String toString() {
        return "ArrangeRule{" +
                "ruleId=" + ruleId +
                ", name='" + name + '\'' +
                ", pointNum=" + pointNum +
                ", content='" + content + '\'' +
                '}';
    }

    public ArrangeRule(Integer ruleId, String name, Integer pointNum, String content) {
        this.ruleId = ruleId;
        this.name = name;
        this.pointNum = pointNum;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    @Column(name = "name",length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "point_num",length = 100)
    public Integer getPointNum() {
        return pointNum;
    }

    public void setPointNum(Integer pointNum) {
        this.pointNum = pointNum;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
