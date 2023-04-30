package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.PhysicalAssessment;
import me.dio.academia.digital.entity.Student;
import me.dio.academia.digital.entity.form.StudentForm;
import me.dio.academia.digital.entity.form.StudentUpdateForm;
import me.dio.academia.digital.service.impl.StudentServiceImpl;

@RestController

public class StudentController {
    
    @Autowired
    private StudentServiceImpl service;

    @GetMapping("/alunos")
    public List<Student> getAll(@RequestParam(value = "bornDate", required = false) String bornDate){
        return service.getAll(bornDate);
    }

    @GetMapping("alunos/{id}")
    public Student getOne(@PathVariable("id") Long id){
        return service.get(id);
    }

    @PostMapping("/alunos")
    public Student createStudents(@Valid @RequestBody StudentForm form){
        return service.create(form);
    }

    @GetMapping("alunos/avaliacoes/{id}")
    public List<PhysicalAssessment> getAllPhysicalAssessmentById(@PathVariable Long id){
        return service.getAllPhysicalAssessmentById(id);
    }

    @PutMapping("/alunos/{id}")
    public Student updateStudent(@Valid @PathVariable("id") Long id, @RequestBody StudentUpdateForm form){
        return service.update(id, form);
    } 

    @DeleteMapping("/alunos/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        service.delete(id);
    }
}
