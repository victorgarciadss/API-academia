package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Registration;
import me.dio.academia.digital.service.impl.RegistrationServiceImpl;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationServiceImpl service;

    @GetMapping("/matriculas")
    public List<Registration> getAll(
        @RequestParam(value = "neighborhood", required = false) String neighborHood){
            return service.getAll(neighborHood);
        }
}
