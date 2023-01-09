package com.gestion.cabinetmedical.controllers;

import com.gestion.cabinetmedical.controllers.api.RendezVousApi;
import com.gestion.cabinetmedical.dto.RendezVousDto;
import com.gestion.cabinetmedical.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RendezVousController implements RendezVousApi {

    private RendezVousService rendezVousService;

    @Autowired
    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }

    @Override
    public RendezVousDto save(RendezVousDto dto) {
        return rendezVousService.save(dto);
    }

    @Override
    public RendezVousDto findById(Integer id) {
        return rendezVousService.findById(id);
    }

    @Override
    public List<RendezVousDto> findAll() {
        return rendezVousService.findAll();
    }

    @Override
    public void delete(Integer id) {
        rendezVousService.delete(id);
    }
}
