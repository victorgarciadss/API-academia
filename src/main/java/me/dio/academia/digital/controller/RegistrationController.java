package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Registration;
import me.dio.academia.digital.entity.form.RegistrationForm;
import me.dio.academia.digital.service.impl.RegistrationServiceImpl;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationServiceImpl service;

    @GetMapping("/matriculas")
    public List<Registration> getAll(
        @RequestParam(value = "neighborhood", required = false) String neighborHood
    ){
        return service.getAll(neighborHood);
    }
    
    @GetMapping("matriculas/{id}")
    public Registration getOne(@PathVariable("id") Long id){
        return service.get(id);
    }
    
    @PostMapping("/matriculas")
    public Registration createRegistration(@Valid @RequestBody RegistrationForm form){
        return service.create(form);
    }

    @DeleteMapping("/matriculas/{id}")
    public void deleteRegistration(@PathVariable("id") Long id){
        service.delete(id);
    }
}
