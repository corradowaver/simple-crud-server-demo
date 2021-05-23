package com.molvaoffice.autoservice.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "isForeign")
    private boolean isForeign;

    @Column(name = "num")
    private String num;

    @Column(name = "color")
    private String color;

    @Column(name = "mark")
    private String mark;
}
