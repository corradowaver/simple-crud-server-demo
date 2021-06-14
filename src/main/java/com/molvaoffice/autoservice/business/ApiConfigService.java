package com.molvaoffice.autoservice.business;

import com.molvaoffice.autoservice.domain.dto.ConfigDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ApiConfigService {

    public ConfigDTO getApiConfigValues() {
        return ConfigDTO
                .builder()
                .appName("Generic Hospital")
                .titles(List.of(
                        Map.of("title", "People", "endpoint", "/people"),
                        Map.of("title", "Diagnosis", "endpoint", "/diagnosis"),
                        Map.of("title", "Wards", "endpoint", "/wards")
                ))
                .build();
    }
}
