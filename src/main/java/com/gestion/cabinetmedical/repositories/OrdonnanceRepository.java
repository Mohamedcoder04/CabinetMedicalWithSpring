package com.gestion.cabinetmedical.repositories;

import com.gestion.cabinetmedical.model.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Integer> {
}
