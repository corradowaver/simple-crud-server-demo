package com.molvaoffice.autoservice.business;

import com.molvaoffice.autoservice.db_layer.repository.DiagnosisRepository;
import com.molvaoffice.autoservice.domain.dto.DiagnosisDTO;
import com.molvaoffice.autoservice.domain.entity.DiagnosisEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiagnosisService {

    private final DiagnosisRepository masterRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<DiagnosisDTO> getAllMasters() {
        return masterRepository
                .findAll()
                .stream()
                .map(this::convertMasterEntityToMasterDTO)
                .collect(Collectors.toList());
    }

    public DiagnosisDTO getMaster(Long masterId) {
        return convertMasterEntityToMasterDTO(masterRepository.findById(masterId).get());
    }

    public void deleteMaster(Long masterId) {
        masterRepository.deleteById(masterId);
    }

    public DiagnosisDTO getMasterTemplate() {
        return new DiagnosisDTO();
    }

    public DiagnosisDTO updateMaster(DiagnosisDTO masterDTO) {
        DiagnosisEntity updatedMaster = masterRepository.findById(masterDTO.getId()).get();
        updatedMaster.setName(masterDTO.getName());
        return convertMasterEntityToMasterDTO(masterRepository.save(updatedMaster));
    }

    public DiagnosisDTO createDTO(DiagnosisDTO masterDTO) {
        return convertMasterEntityToMasterDTO(masterRepository.save(convertDTOToEntity(masterDTO)));
    }

    private DiagnosisDTO convertMasterEntityToMasterDTO(DiagnosisEntity masterEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(masterEntity, DiagnosisDTO.class);
    }

    private DiagnosisEntity convertDTOToEntity(DiagnosisDTO masterDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(masterDTO, DiagnosisEntity.class);
    }
}
