package com.JPA.JPA03.DTO;


import com.JPA.JPA03.Annotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "invalid email format")
    private String email;

    @NotNull(message = "age is required")
    @Min(value = 18, message = "age must be at least 18")
    private Integer age;
//@Pattern(regexp = "^ (USER | ADMIN )$",message = "role of employees must be from given")
    @EmployeeRoleValidation(message = "role must be admin or user")
    private String role;
    private LocalDate dateOfJoining;
@JsonProperty("isActive")
    private boolean isActive;

    @JsonIgnore                    // hides the extra "active" key
    public boolean isActive() {
        return isActive;
    }
}
