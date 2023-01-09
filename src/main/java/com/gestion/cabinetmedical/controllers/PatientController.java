package com.gestion.cabinetmedical.controllers;

import com.gestion.cabinetmedical.controllers.api.PatientApi;
import com.gestion.cabinetmedical.dto.PatientDto;
import com.gestion.cabinetmedical.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController implements PatientApi {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public PatientDto save(PatientDto dto) {
        return patientService.save(dto);
    }

    @Override
    public PatientDto findById(Integer id) {
        return patientService.findById(id);
    }

    @Override
    public List<PatientDto> findAll() {
        return patientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        patientService.delete(id);
    }
}
