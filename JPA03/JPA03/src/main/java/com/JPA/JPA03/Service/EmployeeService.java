package com.JPA.JPA03.Service;

import com.JPA.JPA03.DTO.EmployeeDTO;
import com.JPA.JPA03.Entity.EmployeeEntity;
import com.JPA.JPA03.Repository.EmployeeRepository;
import org.apache.el.util.ReflectionUtil;
import org.aspectj.util.Reflection;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id){
//       Optional <EmployeeEntity> employeeEntity= employeeRepository.findById(id);
//      return   modelMapper.map(employeeEntity, EmployeeDTO.class);
        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));

    }


    public List<EmployeeDTO> getAllEmployee() {
  List<EmployeeEntity> employeeEntities= employeeRepository.findAll();

return   employeeEntities
          .stream()
          .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
          .collect(Collectors.toList());
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity toSaveEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
       EmployeeEntity savedEmployeeEntities=employeeRepository.save(toSaveEntity);
       return modelMapper.map(savedEmployeeEntities,EmployeeDTO.class);
    }
// we have created a method to check if employee by id is exits or not
    public boolean exitById(Long employeeId){
        return employeeRepository.existsById(employeeId);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO){
//        EmployeeEntity exit= employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("id not found"));
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeDTO.setId(id);
        EmployeeEntity savedEmployeeEntities=employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntities,EmployeeDTO.class);
    }

    public boolean deleteById(Long id) {
        boolean exitById = exitById(id);
        if(!exitById) return false;
        employeeRepository.deleteById(id);
        return true;
    }

//here Map is checking for string as the variable type like name,email or else and Object is the actual value to inserted in that
    public EmployeeDTO updatePartialEmployee(Long id, Map<String, Object> upadtes) {
        boolean exits = exitById(id);
        if(!exits) return null;
        EmployeeEntity employeeEntity  = employeeRepository.findById(id).get();
        upadtes.forEach((field,value)->{
            Field fieldToBeUpdated= ReflectionUtils.getRequiredField(EmployeeEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);

    }
}
