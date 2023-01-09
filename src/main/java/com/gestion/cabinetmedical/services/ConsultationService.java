package com.gestion.cabinetmedical.services;

import com.gestion.cabinetmedical.dto.ConsultationDto;

import java.util.List;

public interface ConsultationService {
    ConsultationDto save(ConsultationDto dto);

    ConsultationDto findById(Integer id);

    List<ConsultationDto> findAll();

    void delete(Integer id);
}
