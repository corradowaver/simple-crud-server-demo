package com.molvaoffice.autoservice.webapp;

import com.molvaoffice.autoservice.business.ServiceService;
import com.molvaoffice.autoservice.domain.dto.Convertable;
import com.molvaoffice.autoservice.domain.dto.ConvertableDTO;
import com.molvaoffice.autoservice.domain.dto.ServiceDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("services")
@AllArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping
    public List<ConvertableDTO> getAllServices() {
        return serviceService.getAllServices().stream().map(Convertable::convertToObjectWithTypes).collect(Collectors.toList());
    }

    @GetMapping("/template")
    public ConvertableDTO getCarTemplate() {
        return serviceService.getServiceTemplate().convertToObjectWithTypes();
    }

    @GetMapping("{id}")
    public ConvertableDTO getService(@PathVariable Long id) {
        return serviceService.getService(id).convertToObjectWithTypes();
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }

    @PutMapping
    public ConvertableDTO updateService(@RequestBody ServiceDTO service) {
        return serviceService.updateService(service).convertToObjectWithTypes();
    }

    @PostMapping
    public ConvertableDTO createService(@RequestBody ServiceDTO service) {
        return serviceService.createDTO(service).convertToObjectWithTypes();
    }
}
