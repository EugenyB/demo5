package com.example.demo5;

public class UserBean {
    private String name;
    private int age;

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserBean() {
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

    public String getDescription() {
        if (age < 18) return "Kindergarten";
        if (age < 60) return "Work hard";
        return "relax!";
    }
}
