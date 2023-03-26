package com.company.project.controllers;

import com.company.project.entity.Shipment;
import com.company.project.repository.ShipmentRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/all")
    public List<Shipment> showContents(String name, Model model) {
        return repository.findAll();
    }

}
