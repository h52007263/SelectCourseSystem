package com.hzs.util.model;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 排序实体类
 * @date 2019/6/2 9:35
 */

public class SortModel {
    private int id;
    private int hp;
    private int price;

    public SortModel(int id, int hp, int price) {
        this.id = id;
        this.hp = hp;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SortModel{" +
                "id=" + id +
                ", hp=" + hp +
                ", price=" + price +
                '}';
    }
}
