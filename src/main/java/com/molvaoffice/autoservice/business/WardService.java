package com.molvaoffice.autoservice.business;

import com.molvaoffice.autoservice.db_layer.repository.DiagnosisRepository;
import com.molvaoffice.autoservice.db_layer.repository.WardRepository;
import com.molvaoffice.autoservice.domain.dto.WardDTO;
import com.molvaoffice.autoservice.domain.entity.WardEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WardService {

    private final WardRepository wardRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<WardDTO> getAllServices() {
        return wardRepository
                .findAll()
                .stream()
                .map(this::convertServiceEntityToServiceDTO)
                .collect(Collectors.toList());
    }

    public WardDTO getService(Long serviceId) {
        return convertServiceEntityToServiceDTO(wardRepository.findById(serviceId).get());
    }

    public void deleteService(Long serviceId) {
        wardRepository.deleteById(serviceId);
    }

    public WardDTO getServiceTemplate() {
        return new WardDTO();
    }

    public WardDTO updateService(WardDTO serviceDTO) {
        WardEntity updatedService = wardRepository.findById(serviceDTO.getId()).get();
        updatedService.setName(serviceDTO.getName());
        updatedService.setMaxCount(serviceDTO.getMaxCount());
        updatedService.setDiagnosis(diagnosisRepository.findById(serviceDTO.getDiagnosisId()).get());
        return convertServiceEntityToServiceDTO(wardRepository.save(updatedService));
    }

    public WardDTO createDTO(WardDTO serviceDTO) {
        return convertServiceEntityToServiceDTO(wardRepository.save(convertDTOToEntity(serviceDTO)));
    }

    private WardDTO convertServiceEntityToServiceDTO(WardEntity serviceEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(serviceEntity, WardDTO.class);
    }

    private WardEntity convertDTOToEntity(WardDTO serviceDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(serviceDTO, WardEntity.class);
    }
}
