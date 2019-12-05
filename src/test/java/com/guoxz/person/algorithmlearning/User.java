package com.guoxz.person.algorithmlearning;

import java.io.Serializable;

/**
 * <p>Title:User</p>
 * <p>Description: TODO(用一句句话描述该文件做什么) </p>
 * Copyright: Copyright (c) 2019
 * Company: SI-TECH
 *
 * @Author guoxz
 * @Version 1.0
 * @Since 2019年05月27日 11:56
 */
public class User implements Serializable{
    private int id;
    private String name;
    private int age;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
