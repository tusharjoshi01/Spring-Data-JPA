package com.JPA.JPA03.Entity;

import jakarta.persistence.*;

@Entity
public class Student
{
@Id
    private Long id;

private String Name;
@ManyToMany(mappedBy = "teacher_id")
private Teacher teacher;
}
