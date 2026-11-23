package SpringDataJPA.HospitalManagmentSystem.repository;

import SpringDataJPA.HospitalManagmentSystem.dto.BloodGroupStats;
import SpringDataJPA.HospitalManagmentSystem.dto.CPatientInfo;
import SpringDataJPA.HospitalManagmentSystem.dto.PatientInfo;
import SpringDataJPA.HospitalManagmentSystem.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("select p.id as id,p.name as name,p.email as email from PatientEntity p")
    List<PatientInfo> getAllPatientsInfo();

    @Query("select new SpringDataJPA.HospitalManagmentSystem.dto.CPatientInfo(p.id,p.name) "+"" +
            "from PatientEntity p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("select new SpringDataJPA.HospitalManagmentSystem.dto.BloodGroupStats(p.bloodGroup, "+
    " COUNT(p)) from PatientEntity p group by p.bloodGroup order by COUNT(p)")
    List<BloodGroupStats> getAllPatientsBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE PatientEntity p set p.name=:name where id=:id")
    int updatePatientNameWithId(@Param("name") String name,@Param("id") String id);
}
