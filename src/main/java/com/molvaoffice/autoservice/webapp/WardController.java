package com.molvaoffice.autoservice.webapp;

import com.molvaoffice.autoservice.business.WardService;
import com.molvaoffice.autoservice.domain.dto.Convertable;
import com.molvaoffice.autoservice.domain.dto.ConvertableDTO;
import com.molvaoffice.autoservice.domain.dto.WardDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("wards")
@AllArgsConstructor
public class WardController {

    private final WardService wardService;

    @GetMapping
    public List<ConvertableDTO> getAllServices() {
        return wardService.getAllServices().stream().map(Convertable::convertToObjectWithTypes).collect(Collectors.toList());
    }

    @GetMapping("/template")
    public ConvertableDTO getCarTemplate() {
        return wardService.getServiceTemplate().convertToObjectWithTypes();
    }

    @GetMapping("{id}")
    public ConvertableDTO getService(@PathVariable Long id) {
        return wardService.getService(id).convertToObjectWithTypes();
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable Long id) {
        wardService.deleteService(id);
    }

    @PutMapping
    public ConvertableDTO updateService(@RequestBody WardDTO service) {
        return wardService.updateService(service).convertToObjectWithTypes();
    }

    @PostMapping
    public ConvertableDTO createService(@RequestBody WardDTO service) {
        return wardService.createDTO(service).convertToObjectWithTypes();
    }
}
