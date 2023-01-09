package com.gestion.cabinetmedical.repositories;

import com.gestion.cabinetmedical.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {

}
