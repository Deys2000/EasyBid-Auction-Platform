package com.company.project.controllers;

import com.company.project.entity.Shipment;
import com.company.project.repository.ShipmentRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class HomeController {

    @Autowired
    private ShipmentRepository repository;
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    // Shows all the end points in this controller
    @GetMapping("")
    public String getAllEndpoints() {                
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        List<String> endpoints = handlerMethods.keySet().stream()
                .map(RequestMappingInfo::getPatternsCondition)
                .flatMap(patterns -> patterns.getPatterns().stream())
                .collect(Collectors.toList());
        return "You may access the following endpoints:\n" + endpoints.toString();
    }
    
    @PostMapping("/read")
    public Optional<Shipment> read_shipment(@RequestBody String shipment_id) {        
        return repository.findById(Integer.parseInt(shipment_id));
    }

    @GetMapping("/read/all")
    public List<Shipment> read_all_shipments(String name, Model model) {
        return repository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create_shipment(@RequestBody Shipment item){
        repository.save(item);        
        return new ResponseEntity<>("Item Created Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> put_shipment(@RequestBody Shipment item) {    
        repository.save(item);        
        return new ResponseEntity<>("Item Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete_shipment(@RequestBody String shipment_id) {
        repository.deleteById(Integer.parseInt(shipment_id));
        return new ResponseEntity<>("Item Deleted Successfully", HttpStatus.OK);
    }

}
