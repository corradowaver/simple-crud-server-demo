package com.molvaoffice.autoservice.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "people")
@NoArgsConstructor
@AllArgsConstructor
public class PeopleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
    private DiagnosisEntity diagnosis;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ward_id", referencedColumnName = "id")
    private WardEntity ward;
}
