package com.molvaoffice.autoservice.webapp;

import com.molvaoffice.autoservice.business.DiagnosisService;
import com.molvaoffice.autoservice.domain.dto.Convertable;
import com.molvaoffice.autoservice.domain.dto.ConvertableDTO;
import com.molvaoffice.autoservice.domain.dto.DiagnosisDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("diagnosis")
@AllArgsConstructor
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @GetMapping
    public List<ConvertableDTO> getAllMasters() {
        return diagnosisService.getAllMasters().stream().map(Convertable::convertToObjectWithTypes).collect(Collectors.toList());
    }

    @GetMapping("/template")
    public ConvertableDTO getCarTemplate() {
        return diagnosisService.getMasterTemplate().convertToObjectWithTypes();
    }

    @GetMapping("{id}")
    public ConvertableDTO getMaster(@PathVariable Long id) {
        return diagnosisService.getMaster(id).convertToObjectWithTypes();
    }

    @DeleteMapping("{id}")
    public void deleteMaster(@PathVariable Long id) {
        diagnosisService.deleteMaster(id);
    }

    @PutMapping
    public ConvertableDTO updateMaster(@RequestBody DiagnosisDTO master) {
        return diagnosisService.updateMaster(master).convertToObjectWithTypes();
    }

    @PostMapping
    public ConvertableDTO createMaster(@RequestBody DiagnosisDTO master) {
        return diagnosisService.createDTO(master).convertToObjectWithTypes();
    }
}
