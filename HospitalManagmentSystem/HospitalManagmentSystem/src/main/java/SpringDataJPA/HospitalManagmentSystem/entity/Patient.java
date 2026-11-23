package SpringDataJPA.HospitalManagmentSystem.entity;

import SpringDataJPA.HospitalManagmentSystem.type.BloodGroup;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientId")
    private Long id;

    private String name;

    private String gender;

    private LocalDate birthDate;

    private String email;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    private LocalDateTime createAt;

    @OneToOne
    @JoinColumn(name = "patient_insurance")
    private Insurance insurance;


    @OneToOne(mappedBy = "patient")
    private Set<Appointment> appointments = new HashSet<>();


}
