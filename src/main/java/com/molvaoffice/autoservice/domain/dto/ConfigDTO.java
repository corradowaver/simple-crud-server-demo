package com.molvaoffice.autoservice.domain.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfigDTO {

    private String appName;
    private List<Map<String, String>> titles;
}
