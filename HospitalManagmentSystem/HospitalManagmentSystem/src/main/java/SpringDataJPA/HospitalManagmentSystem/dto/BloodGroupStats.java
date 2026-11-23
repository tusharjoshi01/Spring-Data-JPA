package SpringDataJPA.HospitalManagmentSystem.dto;

import SpringDataJPA.HospitalManagmentSystem.type.BloodGroup;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroup bloodGroup;

    private  final Long count;
}
