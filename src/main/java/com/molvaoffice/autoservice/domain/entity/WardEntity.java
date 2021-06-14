package com.molvaoffice.autoservice.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "wards")
@NoArgsConstructor
@AllArgsConstructor
public class WardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_count")
    private Integer maxCount;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
    private DiagnosisEntity diagnosis;
}
