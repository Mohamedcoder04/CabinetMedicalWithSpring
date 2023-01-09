package com.gestion.cabinetmedical.repositories;

import com.gestion.cabinetmedical.dto.SecretaireDto;
import com.gestion.cabinetmedical.model.Secretaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecretaireRepository extends JpaRepository<Secretaire, Integer> {
    Optional<Secretaire> findByEmail(String email);
}
