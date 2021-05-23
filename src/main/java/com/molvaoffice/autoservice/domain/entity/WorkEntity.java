package com.molvaoffice.autoservice.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@Table(name = "work")
@NoArgsConstructor
@AllArgsConstructor
public class WorkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "dateWork")
    private LocalDate dateWork;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masterId", referencedColumnName = "id")
    private MasterEntity master;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private CarEntity car;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceId", referencedColumnName = "id")
    private ServiceEntity service;
}

