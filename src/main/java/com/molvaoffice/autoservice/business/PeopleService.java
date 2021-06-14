package com.molvaoffice.autoservice.business;

import com.molvaoffice.autoservice.db_layer.repository.DiagnosisRepository;
import com.molvaoffice.autoservice.db_layer.repository.WardRepository;
import com.molvaoffice.autoservice.domain.dto.PeopleDTO;
import com.molvaoffice.autoservice.db_layer.repository.PeopleRepository;
import com.molvaoffice.autoservice.domain.entity.PeopleEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PeopleService {

    private final PeopleRepository peopleRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final WardRepository wardRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<PeopleDTO> getAllCars() {
        return peopleRepository
                .findAll()
                .stream()
                .map(this::convertCarEntityToCarDTO)
                .collect(Collectors.toList());
    }

    public PeopleDTO getCar(Long peopleId) {
        return convertCarEntityToCarDTO(peopleRepository.findById(peopleId).get());
    }

    public void deleteCar(Long peopleId) {
        peopleRepository.deleteById(peopleId);
    }

    public PeopleDTO getCarTemplate() {
        return new PeopleDTO();
    }

    public PeopleDTO updateCar(PeopleDTO peopleDTO) {
        PeopleEntity updatedCar = peopleRepository.findById(peopleDTO.getId()).get();
        updatedCar.setFirstName(peopleDTO.getFirstName());
        updatedCar.setLastName(peopleDTO.getLastName());
        updatedCar.setFatherName(peopleDTO.getFatherName());
        updatedCar.setDiagnosis(diagnosisRepository.findById(peopleDTO.getDiagnosisId()).get());
        updatedCar.setWard(wardRepository.findById(peopleDTO.getWardId()).get());
        return convertCarEntityToCarDTO(peopleRepository.save(updatedCar));
    }

    public PeopleDTO createDTO(PeopleDTO peopleDTO) {
        return convertCarEntityToCarDTO(peopleRepository.save(convertDTOToEntity(peopleDTO)));
    }

    private PeopleDTO convertCarEntityToCarDTO(PeopleEntity peopleEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(peopleEntity, PeopleDTO.class);
    }

    private PeopleEntity convertDTOToEntity(PeopleDTO peopleDTO) {
        return PeopleEntity
            .builder()
            .id(peopleDTO.getId())
            .firstName(peopleDTO.getFirstName())
            .lastName(peopleDTO.getLastName())
            .fatherName(peopleDTO.getFatherName())
            .diagnosis(diagnosisRepository.findById(peopleDTO.getDiagnosisId()).get())
            .ward(wardRepository.findById(peopleDTO.getWardId()).get())
            .build();
    }
}
