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
      Optional  <EmployeeDTO> employeeDTO =employeeService.getEmployeeById(Id);
      return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping("/post")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee =employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
      boolean gotDeleted = employeeService.deleteById(id);
      if (gotDeleted) return ResponseEntity.ok(true);
      return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployee(@PathVariable Long id, @RequestBody Map<String,Object> updates){
        EmployeeDTO employeeDTO= employeeService.updatePartialEmployee(id,updates);
        if (employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
