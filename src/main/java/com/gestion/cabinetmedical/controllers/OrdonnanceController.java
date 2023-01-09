package com.gestion.cabinetmedical.controllers;

import com.gestion.cabinetmedical.controllers.api.OrdonnanceApi;
import com.gestion.cabinetmedical.dto.OrdonnanceDto;
import com.gestion.cabinetmedical.services.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrdonnanceController implements OrdonnanceApi {

    private OrdonnanceService ordonnanceService;

    @Autowired
    public OrdonnanceController(OrdonnanceService ordonnanceService) {
        this.ordonnanceService = ordonnanceService;
    }

    @Override
    public OrdonnanceDto save(OrdonnanceDto dto) {
        return ordonnanceService.save(dto);
    }

    @Override
    public OrdonnanceDto findById(Integer id) {
        return ordonnanceService.findById(id);
    }

    @Override
    public List<OrdonnanceDto> findAll() {
        return ordonnanceService.findAll();
    }

    @Override
    public void delete(Integer id) {
        ordonnanceService.delete(id);
    }
}
