package com.JPA.JPA03.Controller;

import com.JPA.JPA03.Entity.EmployeeEntity;
import com.JPA.JPA03.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;



@GetMapping("/Id")
public Optional<EmployeeEntity> getEmployeeById(@PathVariable Long Id){
    return employeeRepository.findById(Id);
}
@GetMapping
public List<EmployeeEntity> getAllEmployee(){
    return employeeRepository.findAll();
}
@PostMapping
public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity){
    return employeeRepository.save(employeeEntity);
}


}
