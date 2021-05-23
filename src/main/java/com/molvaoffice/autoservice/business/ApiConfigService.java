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
                .appName("Autoservice")
                .titles(List.of(
                        Map.of("title", "Cars", "endpoint", "/cars"),
                        Map.of("title", "Masters", "endpoint", "/masters"),
                        Map.of("title", "Services", "endpoint", "/services"),
                        Map.of("title", "Works", "endpoint", "/works")
                ))
                .build();
    }
}
