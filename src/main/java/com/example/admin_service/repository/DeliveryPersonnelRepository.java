package com.example.admin_service.repository;

import com.example.admin_service.entity.DeliveryPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPersonnelRepository extends JpaRepository<DeliveryPersonnel, Long> {
}
