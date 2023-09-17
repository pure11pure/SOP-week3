package com.example.week3;

import org.springframework.web.bind.annotation.*;

@RestController
public class Customer {
    private String ID;
    private String name;
    private Boolean sex;
    private int age;

    public Customer(){
        this("", null, false, 0);
    }

    public Customer(String ID, String n, boolean s, int a){
        this.ID = ID;
        this.name = n;
        this.sex = s;
        this.setAge(a);
//        this.age = a;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    public Boolean getSex() {
        return sex;
    }

    public void setAge(int age) {
        if(age > 0){
            this.age = age;
        }
        else {
            this.age = 0;
        }
    }
    public int getAge() {
        return age;
    }
}
