package com.JPA.JPA02.Repository;

import com.JPA.JPA02.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop,Long> {
}
