package com.digitalholics.patientservice.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "therapies")
public class Therapy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "theraphy_name")
    @Size(max = 300)
    private String theraphyName;

    @NotNull
    @NotBlank
    @Column(name = "appointment_quantity")
    @Size(max = 300)
    private String appointmentQuantity;

    @NotNull
    @NotBlank
    @Column(name = "appointment_gap")
    @Size(max = 300)
    private String appointmentGap;

    @NotNull
    @NotBlank
    @Column(name = "start_at")
    private String startAt;

    @NotNull
    @NotBlank
    @Column(name = "finish_at")
    private String finishAt;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, mappedBy = "therapy")
    private Set<Treatment> treatments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, mappedBy = "appointment")
    private Set<Appointment> appointments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;
}
