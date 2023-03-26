package com.company.project.controllers;

import com.company.project.entity.Shipment;
import com.company.project.repository.ShipmentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private ShipmentRepository repository;

    @GetMapping("/")
    public Shipment showHome(String name, Model model) {
        return repository.findById(2).orElse(new Shipment("Not Found 😕"));
    }
    
    @GetMapping("/all")
    public List<Shipment> showContents(String name, Model model) {
        return repository.findAll();
    }

}
