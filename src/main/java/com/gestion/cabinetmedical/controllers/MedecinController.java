package com.gestion.cabinetmedical.controllers;

import com.gestion.cabinetmedical.controllers.api.MedecinApi;
import com.gestion.cabinetmedical.dto.MedecinDto;
import com.gestion.cabinetmedical.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedecinController implements MedecinApi {

    private MedecinService medecinService;

    @Autowired
    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @Override
    public MedecinDto save(MedecinDto dto) {
        return medecinService.save(dto);
    }

    @Override
    public MedecinDto findById(Integer id) {
        return medecinService.findById(id);
    }

    @Override
    public List<MedecinDto> findAll() {
        return medecinService.findAll();
    }

    @Override
    public void delete(Integer id) {
        medecinService.delete(id);
    }
}
