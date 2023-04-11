package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.PhysicalAssessment;
import me.dio.academia.digital.entity.form.PhysicalAssessmentForm;
import me.dio.academia.digital.service.impl.PhysicalAssessmentServiceImpl;

@RestController

public class PhysicalAssessmentController {

    @Autowired
    private PhysicalAssessmentServiceImpl service;

    @GetMapping("/avaliacoes")
    public List<PhysicalAssessment> getAll(){
        return service.getAll();
    }

    @PostMapping("/avaliacoes")
    public PhysicalAssessment create(@RequestBody PhysicalAssessmentForm form){
        return service.create(form);
    }
}
