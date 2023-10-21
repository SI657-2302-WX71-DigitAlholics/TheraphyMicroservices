package com.digitalholics.patientservice.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "treatments")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "video_url")
    private String videoUrl;

    @NotNull
    @NotBlank
    @Column(name = "duration")
    private String duration;

    @NotNull
    @NotBlank
    @Column(name = "title")
    private String title;

    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;

    @NotNull
    @NotBlank
    @Column(name = "day")
    private String day;


    @NotNull
    @Column(name = "viewed")
    private Boolean viewed;


    @ManyToOne
    @JoinColumn(name = "theraphy_id")
    @JsonIgnore
    private Therapy therapy;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, mappedBy = "result")
    private Set<Result> results = new HashSet<>();
}
