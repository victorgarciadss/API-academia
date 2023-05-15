package me.dio.academia.digital.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;
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
    public ResponseEntity<Student> getOne(@PathVariable("id") Long id){
        try{
            Student student = service.get(id);
            return ResponseEntity.ok(student);
        }
        catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping("/alunos")
    public Student createStudents(@Valid @RequestBody StudentForm form){
        return service.create(form);
    }

    @GetMapping("alunos/avaliacoes/{id}")
    public ResponseEntity<List<PhysicalAssessment>> getAllPhysicalAssessmentById(@PathVariable Long id){
        try{
            List<PhysicalAssessment> physicalAssessments = service.getAllPhysicalAssessmentById(id);
            return ResponseEntity.ok(physicalAssessments);
        }
        catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/alunos/{id}")
    public ResponseEntity<Student> updateStudent
        (@PathVariable("id") Long id, @Valid @RequestBody StudentUpdateForm form)
    {
        try{
            Student updatedStudent = service.update(id, form);
            return ResponseEntity.ok(updatedStudent);
        }
        catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        
        
        
    } 

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
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
