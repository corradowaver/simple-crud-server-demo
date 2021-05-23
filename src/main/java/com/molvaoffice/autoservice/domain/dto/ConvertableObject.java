package com.molvaoffice.autoservice.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConvertableObject {
    private String fieldName;
    private String fieldType;
    private Object fieldValue;
}
