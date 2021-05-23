package com.molvaoffice.autoservice.domain.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkDTO implements Convertable {
    private Long id;
    private LocalDate dateWork;
    private Long masterId;
    private Long carId;
    private Long serviceId;
}
