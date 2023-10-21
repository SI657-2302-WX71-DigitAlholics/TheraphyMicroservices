package com.digitalholics.patientservice.domain.model.entity;

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
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @NotNull
    @Column(name = "name")
    @Size(max = 300)
    private String name;

    @NotNull
    @Column(name = "cost")
    private Double cost;

    @NotBlank
    @NotNull
    @Column(name = "magnitudes")
    @Size(max = 300)
    private String magnitudes;

    @NotNull
    @Column(name = "value")
    private Double value;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, mappedBy = "result")
    private Set<Result> results = new HashSet<>();
}
