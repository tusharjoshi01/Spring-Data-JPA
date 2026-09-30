package com.JPA.JPA03.Repository;

import com.JPA.JPA03.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
