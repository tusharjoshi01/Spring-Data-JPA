package SpringDataJPA.HospitalManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50,unique = true)
    private String name;


    // OWNER side: head_doctor_id column is created in the department table.
    // No mappedBy here, because Doctor has no department field.
    @OneToOne
    @JoinColumn(name = "head_doctor_id", nullable = false)
    private Doctor headDoctor;

    // OWNER side: creates the join table my_dpt_doctors (dpt_id, doctor_id)
    @ManyToMany
    @JoinTable(
            name = "my_dpt_doctors",
            joinColumns = @JoinColumn(name = "dpt_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private Set<Doctor> doctors = new HashSet<>();
}
