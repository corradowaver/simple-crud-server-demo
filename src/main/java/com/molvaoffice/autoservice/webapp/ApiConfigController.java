package com.molvaoffice.autoservice.webapp;

import com.molvaoffice.autoservice.business.ApiConfigService;
import com.molvaoffice.autoservice.domain.dto.ConfigDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
@AllArgsConstructor
public class ApiConfigController {

    private final ApiConfigService apiConfigService;

    @GetMapping
    public ConfigDTO getAllTitles() {
        return apiConfigService.getApiConfigValues();
    }
}
