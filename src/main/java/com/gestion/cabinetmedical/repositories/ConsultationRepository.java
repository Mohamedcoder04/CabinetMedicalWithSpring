package com.gestion.cabinetmedical.repositories;

import com.gestion.cabinetmedical.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
}
