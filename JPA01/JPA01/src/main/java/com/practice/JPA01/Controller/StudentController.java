package com.practice.JPA01.Controller;

import com.practice.JPA01.Entity.Student;
import com.practice.JPA01.Repo.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    //   @PostMapping
//    public ResponseEntity<Student> createStudents(@RequestBody Student student){
//        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepo.save(student));
//    }
//    this another way to use response entity
    @PostMapping("/std")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStd(@RequestBody Student student){
        return studentRepo.save(student);
    }
//    @GetMapping
//    public List<Student> getStudents(){
//        return studentRepo.findAll();
//    }
//
    @GetMapping
    public ResponseEntity<List<Student>> getStd(){
        return ResponseEntity.ok(studentRepo.findAll());
    }

    @PutMapping
    public Student updateById(@RequestParam Long id , @RequestBody Student student){
        Student s = studentRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Student not found"));
        s.setEmail(student.getEmail());
        s.setName(student.getName());
        return studentRepo.save(s);
    }
    @PatchMapping
    public Student update(@RequestParam Long id, @RequestParam String name){
        Student s = studentRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("error in put patch mapping"));
        s.setName(name);
        return studentRepo.save(s);
    }


    @DeleteMapping("/{id}")
    public List<Student> DeleteStdById(@PathVariable Long id){
         studentRepo.deleteById(id);
        return  studentRepo.findAll();
    }




}

