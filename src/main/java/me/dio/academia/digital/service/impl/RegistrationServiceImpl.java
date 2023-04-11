package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Registration;
import me.dio.academia.digital.entity.form.RegistrationForm;
import me.dio.academia.digital.repository.RegistrationRepository;
import me.dio.academia.digital.service.IResgistrationService;

@Service
public class RegistrationServiceImpl implements IResgistrationService {
    
    @Autowired
    private RegistrationRepository repository;

    @Override
    public Registration create(RegistrationForm form) {
        return null;
    }

    @Override
    public Registration get(Long id) {
        return null;
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
        
    }
    
}
