package me.dio.academia.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.academia.digital.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    List<Registration> findByStudentNeighborhood(String neighborhood);
}
