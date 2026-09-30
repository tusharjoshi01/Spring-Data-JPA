package com.practice.JPA01.Repo;

import com.practice.JPA01.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//here we describe for which class the repo is created and what is type of its primary key
public interface StudentRepo extends JpaRepository<Student, Long> {


}
