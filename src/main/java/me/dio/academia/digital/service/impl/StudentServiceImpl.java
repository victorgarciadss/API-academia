package me.dio.academia.digital.service.impl;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.PhysicalAssessment;
import me.dio.academia.digital.entity.Student;
import me.dio.academia.digital.entity.form.StudentForm;
import me.dio.academia.digital.entity.form.StudentUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.StudentRepository;
import me.dio.academia.digital.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student create(StudentForm form) {

        Student student = new Student();
        student.setName(form.getName());
        student.setCpf(form.getCpf());
        student.setNeighborhood(form.getNeighborhood());
        student.setBornDate(form.getBornDate());

        return repository.save(student);
    
    }

    @Override
    public Student get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Student> getAll(String bornDate) {
        if(bornDate == null){
            return repository.findAll();
        }
        else{
            LocalDate localDate = LocalDate.parse(bornDate, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByBornDate(localDate);
        }
    }

    @Override
    public Student update(Long id, StudentUpdateForm formUpdate) {

        Student updatedStudent = repository.getById(id);

        updatedStudent.setName(formUpdate.getName());
        updatedStudent.setNeighborhood(formUpdate.getNeighborhood());
        updatedStudent.setBornDate(formUpdate.getBornDate());

        return repository.save(updatedStudent);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<PhysicalAssessment> getAllPhysicalAssessmentById(Long id){
        Student student = repository.findById(id).get();

        return student.getAssessments();
    }
    
}
