package com.gestion.cabinetmedical.services;

import com.gestion.cabinetmedical.dto.MedecinDto;

import java.util.List;

public interface MedecinService {

    MedecinDto save(MedecinDto dto);

    MedecinDto findById(Integer id);

    List<MedecinDto> findAll();

    void delete(Integer id);
}
