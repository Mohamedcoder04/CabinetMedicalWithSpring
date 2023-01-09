package com.gestion.cabinetmedical.controllers;

import com.gestion.cabinetmedical.controllers.api.ConsultationApi;
import com.gestion.cabinetmedical.dto.ConsultationDto;
import com.gestion.cabinetmedical.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultationController implements ConsultationApi {
    private ConsultationService consultationService;

    @Autowired
    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @Override
    public ConsultationDto save(ConsultationDto dto) {
        return consultationService.save(dto);
    }

    @Override
    public ConsultationDto findById(Integer id) {
        return consultationService.findById(id);
    }

    @Override
    public List<ConsultationDto> findAll() {
        return consultationService.findAll();
    }

    @Override
    public void delete(Integer id) {
        consultationService.delete(id);
    }
}
