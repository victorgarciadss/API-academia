package me.dio.academia.digital.service.impl;

import java.util.List;
import java.util.Optional;

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
        Optional<PhysicalAssessment> assessment = physicalAssessmentRepository.findById(id);

        return assessment.orElse(null);
    }

    @Override
    public List<PhysicalAssessment> getAll() {
        return physicalAssessmentRepository.findAll();
    }

    @Override
    public PhysicalAssessment update(Long id, PhysicalAssessmentUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {
        physicalAssessmentRepository.deleteById(id);
    }
    
}
