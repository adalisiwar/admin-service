package com.example.admin_service.controller;

import com.example.admin_service.entity.DeliveryPersonnel;
import com.example.admin_service.service.DeliveryPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/delivery-personnels")
public class DeliveryPersonnelController {

    @Autowired
    private DeliveryPersonnelService deliveryPersonnelService;

    @GetMapping
    public List<DeliveryPersonnel> getAllDeliveryPersonnels() {
        return deliveryPersonnelService.getAllDeliveryPersonnels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryPersonnel> getDeliveryPersonnelById(@PathVariable Long id) {
        return deliveryPersonnelService.getDeliveryPersonnelById(id)
                .map(deliveryPersonnel -> ResponseEntity.ok().body(deliveryPersonnel))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DeliveryPersonnel createDeliveryPersonnel(@Valid @RequestBody DeliveryPersonnel deliveryPersonnel) {
        return deliveryPersonnelService.createDeliveryPersonnel(deliveryPersonnel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryPersonnel> updateDeliveryPersonnel(@PathVariable Long id, @Valid @RequestBody DeliveryPersonnel deliveryPersonnelDetails) {
        DeliveryPersonnel updatedDeliveryPersonnel = deliveryPersonnelService.updateDeliveryPersonnel(id, deliveryPersonnelDetails);
        if (updatedDeliveryPersonnel != null) {
            return ResponseEntity.ok(updatedDeliveryPersonnel);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryPersonnel(@PathVariable Long id) {
        deliveryPersonnelService.deleteDeliveryPersonnel(id);
        return ResponseEntity.noContent().build();
    }
}
