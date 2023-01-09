package com.gestion.cabinetmedical.services;

import com.gestion.cabinetmedical.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto save(PatientDto dto);

    PatientDto findById(Integer id);

    List<PatientDto> findAll();

    void delete(Integer id);
}
