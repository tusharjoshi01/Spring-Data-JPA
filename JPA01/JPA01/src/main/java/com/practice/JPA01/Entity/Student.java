package com.practice.JPA01.Entity;

import jakarta.persistence.*;

import java.lang.reflect.Type;
@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stdid;

    private String name;

    private String email;

    public Student(){

    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getStdid() {
        return stdid;
    }

    public void setStdid(long stdid) {
        this.stdid = stdid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
