package com.JPA.JPA02.Controller;


import com.JPA.JPA02.Entity.Laptop;
import com.JPA.JPA02.Entity.Student;
import com.JPA.JPA02.Repository.LaptopRepo;
import com.JPA.JPA02.Repository.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/s")
public class StudentController {
    private final StudentRepo studentRepo;
    private final LaptopRepo laptopRepo;



    public StudentController(StudentRepo studentRepo, LaptopRepo laptopRepo) {
        this.studentRepo = studentRepo;
        this.laptopRepo = laptopRepo;
    }
    @PostMapping("/post")
    public Student updateData(@RequestBody Student student) {
        if (student.getLaptop() != null) {
            student.getLaptop().setStudent(student);
        }
        return studentRepo.save(student);
    }
  @GetMapping("/get")
    public List<Student> getData(){
        return studentRepo.findAll();
    }
}
