package com.JPA.JPA03.Controller;

import com.JPA.JPA03.DTO.EmployeeDTO;
import com.JPA.JPA03.Entity.EmployeeEntity;
import com.JPA.JPA03.Repository.EmployeeRepository;
import com.JPA.JPA03.Service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")


public class EmployeeController {

    private final EmployeeService employeeService;



    public EmployeeController ( EmployeeService employeeService){
        this.employeeService = employeeService;


    }

    @GetMapping("/Id")
public EmployeeDTO getEmployeeById(@PathVariable Long Id){
    return employeeService.getEmployeeById(Id);
}
@GetMapping
public List<EmployeeDTO> getAllEmployee(){
    return employeeService.getAllEmployee();
}
@PostMapping("/post")
public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEntity){
    return employeeService.createEmployee(inputEmpEntity);
}


}
