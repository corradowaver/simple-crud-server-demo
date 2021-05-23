package com.molvaoffice.autoservice.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO implements Convertable {
    private Long id;
    private String name;
    private Integer costOur;
    private Integer costForeign;
}
