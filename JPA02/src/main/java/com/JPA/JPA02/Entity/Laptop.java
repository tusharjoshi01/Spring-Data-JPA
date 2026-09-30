package com.JPA.JPA02.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    @OneToOne
    @JoinColumn(name = "student_id", unique = true)
    @JsonBackReference
    private Student student;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}