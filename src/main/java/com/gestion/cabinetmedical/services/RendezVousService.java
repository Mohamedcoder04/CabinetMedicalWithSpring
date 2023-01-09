package com.gestion.cabinetmedical.services;

import com.gestion.cabinetmedical.dto.RendezVousDto;

import java.util.List;

public interface RendezVousService {

    RendezVousDto save(RendezVousDto dto);

    RendezVousDto findById(Integer id);

    List<RendezVousDto> findAll();

    void delete(Integer id);
}
