package com.example.traini8Assgn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;


import java.util.List;

@Entity
@Table(name = "training_center")
@Data
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotBlank(message = "Center Name required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center Code required")
    @Pattern(regexp="^[a-zA-Z0-9]{12}$", message="Center code must be exactly 12 alphanumeric characters")
    private String centerCode;
    @Valid
    @NotNull(message = "Address cannot be null")
    private Address address;
    private Long studentCapacity;
    private List<String> coursesOffered;
    @JsonIgnore
    private Long createdOn;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp="^[0-9]{10}$", message="Mobile number should be exactly 10 digits")
    private String contactPhone;
}
