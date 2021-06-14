package com.molvaoffice.autoservice.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WardDTO implements Convertable {
    private Long id;
    private String name;
    private Integer maxCount;
    private Long diagnosisId;
}
