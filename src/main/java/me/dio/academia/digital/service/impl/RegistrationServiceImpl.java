package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Registration;
import me.dio.academia.digital.entity.Student;
import me.dio.academia.digital.entity.form.RegistrationForm;
import me.dio.academia.digital.repository.RegistrationRepository;
import me.dio.academia.digital.repository.StudentRepository;
import me.dio.academia.digital.service.IResgistrationService;

@Service
public class RegistrationServiceImpl implements IResgistrationService {
    
    @Autowired
    private RegistrationRepository repository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Registration create(RegistrationForm form) {
        
        Registration newRegistration = new Registration();
        Student student = studentRepository.findById(form.getStudentId()).get();

        newRegistration.setId(form.getStudentId());
        newRegistration.setStudent(student);

        return repository.save(newRegistration);
    }

    @Override
    public Registration get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Registration> getAll(String neighborhood) {

        if(neighborhood == null){
            return repository.findAll();
        }
        else{
            return repository.findByStudentNeighborhood(neighborhood);
        }
        
    }

    @Override
    public void delete(Long id) {

        Registration registration = repository.findById(id).get();

        registration.setStudent(null);
        repository.save(registration);

        repository.deleteById(id);
    }
    
}
