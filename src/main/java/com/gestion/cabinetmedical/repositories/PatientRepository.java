package com.gestion.cabinetmedical.repositories;

import com.gestion.cabinetmedical.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
