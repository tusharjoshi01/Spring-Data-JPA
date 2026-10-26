package com.JPA.JPA03.Controller;

import com.JPA.JPA03.DTO.EmployeeDTO;
import com.JPA.JPA03.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // FIXED: Changed "/Id" to "/{Id}" so Spring can capture the path variable [1]
    @GetMapping("/{Id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long Id) {
        return employeeService.getEmployeeById(Id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/post")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id,@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id,employeeDTO);
    }
}
