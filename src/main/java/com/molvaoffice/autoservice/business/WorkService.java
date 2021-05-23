package com.molvaoffice.autoservice.business;

import com.molvaoffice.autoservice.db_layer.repository.CarRepository;
import com.molvaoffice.autoservice.db_layer.repository.MasterRepository;
import com.molvaoffice.autoservice.db_layer.repository.ServiceRepository;
import com.molvaoffice.autoservice.db_layer.repository.WorkRepository;
import com.molvaoffice.autoservice.domain.dto.ServiceDTO;
import com.molvaoffice.autoservice.domain.dto.WorkDTO;
import com.molvaoffice.autoservice.domain.entity.ServiceEntity;
import com.molvaoffice.autoservice.domain.entity.WorkEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkService {

    private final WorkRepository workRepository;
    private final ServiceRepository serviceRepository;
    private final CarRepository carRepository;
    private final MasterRepository masterRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<WorkDTO> getAllWorks() {
        return workRepository
                .findAll()
                .stream()
                .map(this::convertWorkEntityToWorkDTO)
                .collect(Collectors.toList());
    }

    public WorkDTO getWork(Long workId) {
        return convertWorkEntityToWorkDTO(workRepository.findById(workId).get());
    }

    public void deleteWork(Long workId) {
        workRepository.deleteById(workId);
    }

    public WorkDTO getWorkTemplate() {
        return new WorkDTO();
    }

    public WorkDTO updateWork(WorkDTO workDTO) {
        WorkEntity updatedWork = workRepository.findById(workDTO.getId()).get();
        updatedWork.setDateWork(workDTO.getDateWork());
        updatedWork.setService(serviceRepository.findById(workDTO.getServiceId()).get());
        updatedWork.setCar(carRepository.findById(workDTO.getCarId()).get());
        updatedWork.setMaster(masterRepository.findById(workDTO.getMasterId()).get());
        return convertWorkEntityToWorkDTO(workRepository.save(updatedWork));
    }

    public WorkDTO createDTO(WorkDTO workDTO) {
        return convertWorkEntityToWorkDTO(workRepository.save(convertDTOToEntity(workDTO)));
    }

    private WorkDTO convertWorkEntityToWorkDTO(WorkEntity workEntity) {
        return WorkDTO
                .builder()
                .dateWork(workEntity.getDateWork())
                .carId(workEntity.getCar().getId())
                .masterId(workEntity.getMaster().getId())
                .serviceId(workEntity.getService().getId())
                .build();
    }

    private WorkEntity convertDTOToEntity(WorkDTO workDTO) {
        WorkEntity workEntity = new WorkEntity();
        workEntity.setDateWork(workDTO.getDateWork());
        workEntity.setService(serviceRepository.findById(workDTO.getServiceId()).get());
        workEntity.setMaster(masterRepository.findById(workDTO.getMasterId()).get());
        workEntity.setCar(carRepository.findById(workDTO.getCarId()).get());
        return workEntity;
    }
}
