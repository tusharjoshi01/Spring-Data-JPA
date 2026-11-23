package SpringDataJPA.HospitalManagmentSystem;

import SpringDataJPA.HospitalManagmentSystem.dto.BloodGroupStats;
import SpringDataJPA.HospitalManagmentSystem.dto.CPatientInfo;
import SpringDataJPA.HospitalManagmentSystem.dto.PatientInfo;
import SpringDataJPA.HospitalManagmentSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientRepository patientRepository;
@Test
    void testPatient(){
        List<PatientInfo> patientEntities = patientRepository.getAllPatientsInfo();
//        List<CPatientInfo> patientInfos = patientRepository.getAllPatientsInfoConcrete();
//        List<BloodGroupStats> bloodGroupStats = patientRepository.getAllPatientsBloodGroupStats();
          int Upadete = patientRepository.updatePatientNameWithId("tushar joshi","1");
    System.out.println(Upadete);

    }
}
