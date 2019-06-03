package com.hzs.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 测试类 主表
 * @date 2019/5/30 8:54
 */
@Entity
@Table(name = "card")
public class Card {
    private  int id;
    private String cardno;

    //card 一对一 person
    private Person person;

    @OneToOne(mappedBy = "card",cascade = CascadeType.ALL)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    @Column(name = "cardno",length = 20)
    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardno='" + cardno + '\'' +
                '}';
    }
}
