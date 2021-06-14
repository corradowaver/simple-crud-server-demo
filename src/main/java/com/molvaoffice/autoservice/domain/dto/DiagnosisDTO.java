package com.molvaoffice.autoservice.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisDTO implements Convertable {
    private Long id;
    private String name;
}
