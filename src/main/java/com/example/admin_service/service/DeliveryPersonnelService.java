package com.example.admin_service.service;

import com.example.admin_service.entity.DeliveryPersonnel;
import com.example.admin_service.repository.DeliveryPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryPersonnelService {

    @Autowired
    private DeliveryPersonnelRepository deliveryPersonnelRepository;

    public List<DeliveryPersonnel> getAllDeliveryPersonnels() {
        return deliveryPersonnelRepository.findAll();
    }

    public Optional<DeliveryPersonnel> getDeliveryPersonnelById(Long id) {
        return deliveryPersonnelRepository.findById(id);
    }

    public DeliveryPersonnel createDeliveryPersonnel(DeliveryPersonnel deliveryPersonnel) {
        return deliveryPersonnelRepository.save(deliveryPersonnel);
    }

    public DeliveryPersonnel updateDeliveryPersonnel(Long id, DeliveryPersonnel deliveryPersonnelDetails) {
        Optional<DeliveryPersonnel> optionalDeliveryPersonnel = deliveryPersonnelRepository.findById(id);
        if (optionalDeliveryPersonnel.isPresent()) {
            DeliveryPersonnel deliveryPersonnel = optionalDeliveryPersonnel.get();
            deliveryPersonnel.setName(deliveryPersonnelDetails.getName());
            deliveryPersonnel.setEmail(deliveryPersonnelDetails.getEmail());
            deliveryPersonnel.setPhone(deliveryPersonnelDetails.getPhone());
            deliveryPersonnel.setVehicleType(deliveryPersonnelDetails.getVehicleType());
            deliveryPersonnel.setLicenseNumber(deliveryPersonnelDetails.getLicenseNumber());
            deliveryPersonnel.setStatus(deliveryPersonnelDetails.getStatus());
            return deliveryPersonnelRepository.save(deliveryPersonnel);
        }
        return null;
    }

    public void deleteDeliveryPersonnel(Long id) {
        deliveryPersonnelRepository.deleteById(id);
    }
}
