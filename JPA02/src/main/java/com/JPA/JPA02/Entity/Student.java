package com.JPA.JPA02.Entity;

import com.JPA.JPA02.Repository.LaptopRepo;
import com.JPA.JPA02.Repository.StudentRepo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity

public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @OneToOne(mappedBy = "student" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Laptop laptop;


}
