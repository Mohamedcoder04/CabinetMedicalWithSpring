package com.gestion.cabinetmedical.services;

import com.gestion.cabinetmedical.dto.MedicamentDto;

import java.util.List;

public interface MedicamentService {

    MedicamentDto save(MedicamentDto dto);

    MedicamentDto findById(Integer id);

    List<MedicamentDto> findAll();

    void delete(Integer id);
}
