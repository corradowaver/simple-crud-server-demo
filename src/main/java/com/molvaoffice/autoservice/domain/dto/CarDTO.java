package com.molvaoffice.autoservice.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO implements Convertable {
    private Long id;
    private String name;
    private boolean isForeign;
    private String num;
    private String color;
    private String mark;
}
