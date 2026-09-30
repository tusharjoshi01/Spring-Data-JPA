package com.JPA.JPA02.Repository;

import com.JPA.JPA02.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student , Long> {
}
