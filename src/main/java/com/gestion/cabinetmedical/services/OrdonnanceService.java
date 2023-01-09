package com.gestion.cabinetmedical.services;

import com.gestion.cabinetmedical.dto.OrdonnanceDto;

import java.util.List;

public interface OrdonnanceService {

    OrdonnanceDto save(OrdonnanceDto dto);

    OrdonnanceDto findById(Integer id);

    List<OrdonnanceDto> findAll();

    void delete(Integer id);
}
