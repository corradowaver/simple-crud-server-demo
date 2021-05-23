package com.molvaoffice.autoservice.business;

import com.molvaoffice.autoservice.db_layer.repository.MasterRepository;
import com.molvaoffice.autoservice.domain.dto.CarDTO;
import com.molvaoffice.autoservice.domain.dto.MasterDTO;
import com.molvaoffice.autoservice.domain.entity.CarEntity;
import com.molvaoffice.autoservice.domain.entity.MasterEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MasterService {

    private final MasterRepository masterRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<MasterDTO> getAllMasters() {
        return masterRepository
                .findAll()
                .stream()
                .map(this::convertMasterEntityToMasterDTO)
                .collect(Collectors.toList());
    }

    public MasterDTO getMaster(Long masterId) {
        return convertMasterEntityToMasterDTO(masterRepository.findById(masterId).get());
    }

    public void deleteMaster(Long masterId) {
        masterRepository.deleteById(masterId);
    }

    public MasterDTO getMasterTemplate() {
        return new MasterDTO();
    }

    public MasterDTO updateMaster(MasterDTO masterDTO) {
        MasterEntity updatedMaster = masterRepository.findById(masterDTO.getId()).get();
        updatedMaster.setName(masterDTO.getName());
        return convertMasterEntityToMasterDTO(masterRepository.save(updatedMaster));
    }

    public MasterDTO createDTO(MasterDTO masterDTO) {
        return convertMasterEntityToMasterDTO(masterRepository.save(convertDTOToEntity(masterDTO)));
    }

    private MasterDTO convertMasterEntityToMasterDTO(MasterEntity masterEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(masterEntity, MasterDTO.class);
    }

    private MasterEntity convertDTOToEntity(MasterDTO masterDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(masterDTO, MasterEntity.class);
    }
}
