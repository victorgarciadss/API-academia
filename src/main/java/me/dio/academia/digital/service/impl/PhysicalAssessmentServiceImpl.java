package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.PhysicalAssessment;
import me.dio.academia.digital.entity.Student;
import me.dio.academia.digital.entity.form.PhysicalAssessmentForm;
import me.dio.academia.digital.entity.form.PhysicalAssessmentUpdateForm;
import me.dio.academia.digital.repository.PhysicalAssessmentRepository;
import me.dio.academia.digital.repository.StudentRepository;
import me.dio.academia.digital.service.IPhysicalAssessmentService;

@Service
public class PhysicalAssessmentServiceImpl implements IPhysicalAssessmentService {

    @Autowired
    private PhysicalAssessmentRepository physicalAssessmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public PhysicalAssessment create(PhysicalAssessmentForm form) {
        PhysicalAssessment physicalAssessment = new PhysicalAssessment();

        Student student = studentRepository.findById(form.getStudentId()).get();

        physicalAssessment.setStudent(student);
        physicalAssessment.setWeight(form.getWeight());
        physicalAssessment.setHigh(form.getHigh());

        return physicalAssessmentRepository.save(physicalAssessment);
        
    }

    @Override
    public PhysicalAssessment get(Long id) {
        return physicalAssessmentRepository.findById(id).get();
    }

    @Override
    public List<PhysicalAssessment> getAll() {
        return physicalAssessmentRepository.findAll();
    }

    @Override
    public PhysicalAssessment update(Long id, PhysicalAssessmentUpdateForm formUpdate) {

        PhysicalAssessment updatedAssessment = physicalAssessmentRepository.findById(id).get();

        updatedAssessment.setWeight(formUpdate.getWeight());
        updatedAssessment.setHigh(formUpdate.getHigh());

        return physicalAssessmentRepository.save(updatedAssessment);
    }

    @Override
    public void delete(Long id) {

        PhysicalAssessment assessment = physicalAssessmentRepository.findById(id).get();
    
        assessment.setStudent(null);
        physicalAssessmentRepository.save(assessment);
    
        physicalAssessmentRepository.deleteById(id);
        
    }
    
}
