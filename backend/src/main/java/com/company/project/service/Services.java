package com.company.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.project.entity.Shipment;
import com.company.project.repository.ShipmentRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class Services {

    
    private ShipmentRepository shipmentRepository;

    
    public Shipment save(Shipment item) {
        return shipmentRepository.save(item);
    }

    
    public List<Shipment> getAllItems() {
        return shipmentRepository.findAll();
    }

    
    public List<Shipment> getItemsByQuery(String query) {
        List<Shipment> items = getAllItems();
        HashSet<Shipment> output = new HashSet<>();        
        for (Shipment item : items) {
            if(Integer.toString(item.getItemId()).contains(query)) output.add(item);
            else if(item.getCarrier().contains(query)) output.add(item);
            else if(item.getShippingTime().contains(query)) output.add(item);
            else if(item.getShippingStatus().contains(query)) output.add(item);
        }

        return (output.size() <= 0) ? null : new ArrayList<>(output);
    }

    
    public Shipment getItemById(int id) {
        //List<Shipment> output = shipmentRepository.findAllById(Collections.singleton(itemId));
        //return (output.size() <= 0) ? null : output.get(0);
        return shipmentRepository.getOne(id);
    }

    
    public boolean updateItem(int id, Shipment update) {
        shipmentRepository.findById(id)
                .map(
                    prev -> {
                        prev.setItemId(update.getItemId());
                        prev.setCarrier(update.getCarrier());
                        prev.setShippingStatus(update.getShippingStatus());
                        prev.setShippingTime(update.getShippingTime());
                        return ResponseEntity.ok(true);
                    }
                ).orElseGet(() ->{
                    shipmentRepository.save(update);
                    return ResponseEntity.ok(false);
                });
        return false;
    }

    
    public void deleteItem(int id) {
        shipmentRepository.deleteById(id);
    }

    public void deleteAllItems(){
        shipmentRepository.deleteAll();
    }
}