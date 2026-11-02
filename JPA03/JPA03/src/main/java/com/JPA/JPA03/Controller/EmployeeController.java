package com.JPA.JPA03.Controller;

import com.JPA.JPA03.DTO.EmployeeDTO;
import com.JPA.JPA03.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // FIXED: Changed "/Id" to "/{Id}" so Spring can capture the path variable [1]
    @GetMapping("/{Id}")
    public ResponseEntity <EmployeeDTO> getEmployeeById(@PathVariable Long Id) {
        EmployeeDTO employeeDTO =employeeService.getEmployeeById(Id);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
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

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id){
      return employeeService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public EmployeeDTO updatePartialEmployee(@PathVariable Long id, @RequestBody Map<String,Object> updates){
        return employeeService.updatePartialEmployee(id,updates);
    }
}
