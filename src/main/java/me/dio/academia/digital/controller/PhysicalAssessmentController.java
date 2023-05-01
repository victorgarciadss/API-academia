package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.PhysicalAssessment;
import me.dio.academia.digital.entity.form.PhysicalAssessmentForm;
import me.dio.academia.digital.entity.form.PhysicalAssessmentUpdateForm;
import me.dio.academia.digital.service.impl.PhysicalAssessmentServiceImpl;

@RestController

public class PhysicalAssessmentController {

    @Autowired
    private PhysicalAssessmentServiceImpl service;

    @GetMapping("/avaliacoes")
    public List<PhysicalAssessment> getAll(){
        return service.getAll();
    }

    @GetMapping("/avaliacoes/{id}")
    public PhysicalAssessment getOneAssessment(@PathVariable("id") Long id){
        return service.get(id);
    }

    @PostMapping("/avaliacoes")
    public PhysicalAssessment create(@RequestBody PhysicalAssessmentForm form){
        return service.create(form);
    }

    @PutMapping("avaliacoes/{id}")
    public PhysicalAssessment updatePhysicalAssessment(
        @PathVariable("id") Long id, @RequestBody PhysicalAssessmentUpdateForm form
    ){
        return service.update(id, form);
    }

    @DeleteMapping("avaliacoes/{id}")
    public void deletePhysicalAssessment(@PathVariable("id") Long id){
        service.delete(id);
    }
}
