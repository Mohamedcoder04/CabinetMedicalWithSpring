package com.gestion.cabinetmedical.controllers;

import com.gestion.cabinetmedical.controllers.api.MedicamentApi;
import com.gestion.cabinetmedical.dto.MedicamentDto;
import com.gestion.cabinetmedical.services.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicamentController implements MedicamentApi {

    private MedicamentService medicamentService;

    @Autowired
    public MedicamentController(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @Override
    public MedicamentDto save(MedicamentDto dto) {
        return medicamentService.save(dto);
    }

    @Override
    public MedicamentDto findById(Integer id) {
        return medicamentService.findById(id);
    }

    @Override
    public List<MedicamentDto> findAll() {
        return medicamentService.findAll();
    }

    @Override
    public void delete(Integer id) {
        medicamentService.delete(id);
    }
}
