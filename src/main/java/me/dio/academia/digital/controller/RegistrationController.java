package me.dio.academia.digital.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Registration> getOne(@PathVariable("id") Long id){
        try{
            Registration registration = service.get(id);
            return ResponseEntity.ok(registration);
        }
        catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        
    }
    
    @PostMapping("/matriculas")
    public Registration createRegistration(@Valid @RequestBody RegistrationForm form){
        return service.create(form);
    }

    @DeleteMapping("/matriculas/{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable("id") Long id){
        try{
            service.delete(id);
            return ResponseEntity.ok().build();
        }
        catch(EmptyResultDataAccessException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Violação de constraint: " + e.getMessage());
        }
        
    }
}
