package com.JPA.JPA03.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {
    @Id
    private Long Id;

    private String name;
    @OneToMany

    private Student student;
}
