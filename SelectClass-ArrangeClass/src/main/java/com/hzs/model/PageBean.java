package com.hzs.model;

import java.util.List;

/**
 * @author hzs
 * @description 分页对象
 * @date 2019/5/23 18:36
 */
public class PageBean<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;
    private Integer curr;
    private Integer limit;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getCurr() {
        return curr;
    }

    public void setCurr(Integer curr) {
        this.curr = curr;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
