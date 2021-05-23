package com.molvaoffice.autoservice.webapp;

import com.molvaoffice.autoservice.business.CarService;
import com.molvaoffice.autoservice.domain.dto.CarDTO;
import com.molvaoffice.autoservice.domain.dto.Convertable;
import com.molvaoffice.autoservice.domain.dto.ConvertableDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<ConvertableDTO> getAllCars() {
        return carService.getAllCars().stream().map(Convertable::convertToObjectWithTypes).collect(Collectors.toList());
    }

    @GetMapping("/template")
    public ConvertableDTO getCarTemplate() {
        return carService.getCarTemplate().convertToObjectWithTypes();
    }

    @GetMapping("{id}")
    public ConvertableDTO getCar(@PathVariable Long id) {
        return carService.getCar(id).convertToObjectWithTypes();
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @PutMapping
    public ConvertableDTO updateCar(@RequestBody CarDTO car) {
        return carService.updateCar(car).convertToObjectWithTypes();
    }

    @PostMapping
    public ConvertableDTO createCar(@RequestBody CarDTO car) {
        return carService.createDTO(car).convertToObjectWithTypes();
    }
}
