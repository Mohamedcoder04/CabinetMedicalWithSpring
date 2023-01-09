package com.gestion.cabinetmedical.repositories;

import com.gestion.cabinetmedical.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Integer> {
}
