package com.molvaoffice.autoservice.webapp;

import com.molvaoffice.autoservice.business.WorkService;
import com.molvaoffice.autoservice.domain.dto.Convertable;
import com.molvaoffice.autoservice.domain.dto.ConvertableDTO;
import com.molvaoffice.autoservice.domain.dto.WorkDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("works")
@AllArgsConstructor
public class WorkController {

    private final WorkService workService;

    @GetMapping
    public List<ConvertableDTO> getAllWorks() {
        return workService.getAllWorks().stream().map(Convertable::convertToObjectWithTypes).collect(Collectors.toList());
    }

    @GetMapping("/template")
    public ConvertableDTO getCarTemplate() {
        return workService.getWorkTemplate().convertToObjectWithTypes();
    }

    @GetMapping("{id}")
    public ConvertableDTO getWork(@PathVariable Long id) {
        return workService.getWork(id).convertToObjectWithTypes();
    }

    @DeleteMapping("{id}")
    public void deleteWork(@PathVariable Long id) {
        workService.deleteWork(id);
    }

    @PutMapping
    public ConvertableDTO updateWork(@RequestBody WorkDTO work) {
        return workService.updateWork(work).convertToObjectWithTypes();
    }

    @PostMapping
    public ConvertableDTO createWork(@RequestBody WorkDTO work) {
        return workService.createDTO(work).convertToObjectWithTypes();
    }
}
