package com.huyd.model;

import java.io.Serializable;

/**
 * Author: huyd
 * Date: 2017/9/9 23:20
 * Description:
 */
public class Data implements Serializable{
    private int id;
    private String name;
    private String age;

    public Data() {
    }

    public Data(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}