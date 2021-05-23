package com.molvaoffice.autoservice.business;

import com.molvaoffice.autoservice.db_layer.repository.ServiceRepository;
import com.molvaoffice.autoservice.domain.dto.ServiceDTO;
import com.molvaoffice.autoservice.domain.entity.ServiceEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<ServiceDTO> getAllServices() {
        return serviceRepository
                .findAll()
                .stream()
                .map(this::convertServiceEntityToServiceDTO)
                .collect(Collectors.toList());
    }

    public ServiceDTO getService(Long serviceId) {
        return convertServiceEntityToServiceDTO(serviceRepository.findById(serviceId).get());
    }

    public void deleteService(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }

    public ServiceDTO getServiceTemplate() {
        return new ServiceDTO();
    }

    public ServiceDTO updateService(ServiceDTO serviceDTO) {
        ServiceEntity updatedService = serviceRepository.findById(serviceDTO.getId()).get();
        updatedService.setName(serviceDTO.getName());
        updatedService.setCostOur(serviceDTO.getCostOur());
        updatedService.setCostForeign(serviceDTO.getCostForeign());
        return convertServiceEntityToServiceDTO(serviceRepository.save(updatedService));
    }

    public ServiceDTO createDTO(ServiceDTO serviceDTO) {
        return convertServiceEntityToServiceDTO(serviceRepository.save(convertDTOToEntity(serviceDTO)));
    }

    private ServiceDTO convertServiceEntityToServiceDTO(ServiceEntity serviceEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(serviceEntity, ServiceDTO.class);
    }

    private ServiceEntity convertDTOToEntity(ServiceDTO serviceDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(serviceDTO, ServiceEntity.class);
    }
}
