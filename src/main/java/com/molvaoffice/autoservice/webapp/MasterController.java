package com.molvaoffice.autoservice.webapp;

import com.molvaoffice.autoservice.business.MasterService;
import com.molvaoffice.autoservice.domain.dto.Convertable;
import com.molvaoffice.autoservice.domain.dto.ConvertableDTO;
import com.molvaoffice.autoservice.domain.dto.MasterDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("masters")
@AllArgsConstructor
public class MasterController {

    private final MasterService masterService;

    @GetMapping
    public List<ConvertableDTO> getAllMasters() {
        return masterService.getAllMasters().stream().map(Convertable::convertToObjectWithTypes).collect(Collectors.toList());
    }

    @GetMapping("/template")
    public ConvertableDTO getCarTemplate() {
        return masterService.getMasterTemplate().convertToObjectWithTypes();
    }

    @GetMapping("{id}")
    public ConvertableDTO getMaster(@PathVariable Long id) {
        return masterService.getMaster(id).convertToObjectWithTypes();
    }

    @DeleteMapping("{id}")
    public void deleteMaster(@PathVariable Long id) {
        masterService.deleteMaster(id);
    }

    @PutMapping
    public ConvertableDTO updateMaster(@RequestBody MasterDTO master) {
        return masterService.updateMaster(master).convertToObjectWithTypes();
    }

    @PostMapping
    public ConvertableDTO createMaster(@RequestBody MasterDTO master) {
        return masterService.createDTO(master).convertToObjectWithTypes();
    }
}
