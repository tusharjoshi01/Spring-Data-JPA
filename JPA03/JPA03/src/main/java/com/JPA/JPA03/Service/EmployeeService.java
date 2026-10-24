package com.JPA.JPA03.Service;

import com.JPA.JPA03.DTO.EmployeeDTO;
import com.JPA.JPA03.Entity.EmployeeEntity;
import com.JPA.JPA03.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        EmployeeEntity employeeEntity= employeeRepository.findById(id).orElse(null);
      return   modelMapper.map(employeeEntity, EmployeeDTO.class);

    }


    public List<EmployeeDTO> getAllEmployee() {
  List<EmployeeEntity> employeeEntities= employeeRepository.findAll();

return   employeeEntities
          .stream()
          .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
          .collect(Collectors.toList());
    }

    public EmployeeDTO createEmployee(EmployeeDTO inputEntity) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEntity,EmployeeEntity.class);
       EmployeeEntity savedEmployeeEntities=employeeRepository.save(toSaveEntity);
       return modelMapper.map(savedEmployeeEntities,EmployeeDTO.class);
    }
}
