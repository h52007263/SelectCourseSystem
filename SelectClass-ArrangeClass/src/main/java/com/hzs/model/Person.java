package com.hzs.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 测试类  从表
 * @date 2019/5/30 8:54
 */
@Entity
@Table(name = "person")
public class Person {
    private int id;
    private String name;

    //person  一对一  card
    private Card card;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid")
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Id
    @GenericGenerator(name = "id",strategy = "assigned")
    @GeneratedValue(generator = "id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name",length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
