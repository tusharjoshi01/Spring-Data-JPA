package SpringDataJPA.HospitalManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false , length = 50)
    private String Specialization;
    @Column(nullable = false,length = 50,unique = true)
    private String email;

    // INVERSE side: doctor is the field name inside Appointment
    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments = new HashSet<>();

    // INVERSE side: doctors is the field name inside Department
    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();

}
