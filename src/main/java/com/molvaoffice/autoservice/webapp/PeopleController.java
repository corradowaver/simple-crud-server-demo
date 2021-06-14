package com.molvaoffice.autoservice.webapp;

import com.molvaoffice.autoservice.business.PeopleService;
import com.molvaoffice.autoservice.domain.dto.PeopleDTO;
import com.molvaoffice.autoservice.domain.dto.Convertable;
import com.molvaoffice.autoservice.domain.dto.ConvertableDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("people")
@AllArgsConstructor
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping
    public List<ConvertableDTO> getAllCars() {
        return peopleService.getAllCars().stream().map(Convertable::convertToObjectWithTypes).collect(Collectors.toList());
    }

    @GetMapping("/template")
    public ConvertableDTO getCarTemplate() {
        return peopleService.getCarTemplate().convertToObjectWithTypes();
    }

    @GetMapping("{id}")
    public ConvertableDTO getCar(@PathVariable Long id) {
        return peopleService.getCar(id).convertToObjectWithTypes();
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id) {
        peopleService.deleteCar(id);
    }

    @PutMapping
    public ConvertableDTO updateCar(@RequestBody PeopleDTO car) {
        return peopleService.updateCar(car).convertToObjectWithTypes();
    }

    @PostMapping
    public ConvertableDTO createCar(@RequestBody PeopleDTO car) {
        return peopleService.createDTO(car).convertToObjectWithTypes();
    }
}
