package com.company.project.repository;

import com.company.project.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
}
