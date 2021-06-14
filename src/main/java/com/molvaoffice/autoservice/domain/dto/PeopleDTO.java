package com.molvaoffice.autoservice.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO implements Convertable {
    private Long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Long diagnosisId;
    private Long wardId;
}
