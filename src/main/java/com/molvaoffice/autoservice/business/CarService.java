package com.molvaoffice.autoservice.business;

import com.molvaoffice.autoservice.domain.dto.CarDTO;
import com.molvaoffice.autoservice.db_layer.repository.CarRepository;
import com.molvaoffice.autoservice.domain.entity.CarEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<CarDTO> getAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(this::convertCarEntityToCarDTO)
                .collect(Collectors.toList());
    }

    public CarDTO getCar(Long carId) {
        return convertCarEntityToCarDTO(carRepository.findById(carId).get());
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    public CarDTO getCarTemplate() {
        return new CarDTO();
    }

    public CarDTO updateCar(CarDTO carDTO) {
        CarEntity updatedCar = carRepository.findById(carDTO.getId()).get();
        updatedCar.setMark(carDTO.getMark());
        updatedCar.setNum(carDTO.getNum());
        updatedCar.setColor(carDTO.getColor());
        updatedCar.setForeign(carDTO.isForeign());
        return convertCarEntityToCarDTO(carRepository.save(updatedCar));
    }

    public CarDTO createDTO(CarDTO carDTO) {
        return convertCarEntityToCarDTO(carRepository.save(convertDTOToEntity(carDTO)));
    }

    private CarDTO convertCarEntityToCarDTO(CarEntity carEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(carEntity, CarDTO.class);
    }

    private CarEntity convertDTOToEntity(CarDTO carDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(carDTO, CarEntity.class);
    }
}
