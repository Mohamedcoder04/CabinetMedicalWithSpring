package com.gestion.cabinetmedical.controllers;

import com.gestion.cabinetmedical.controllers.api.SecretaireApi;
import com.gestion.cabinetmedical.dto.MedecinDto;
import com.gestion.cabinetmedical.dto.SecretaireDto;
import com.gestion.cabinetmedical.services.SecretaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecretaireController implements SecretaireApi{
    private SecretaireService secretaireService;
    @Autowired
    public SecretaireController(SecretaireService secretaireService) {
        this.secretaireService = secretaireService;
    }

    @Override
    public SecretaireDto save(SecretaireDto dto) {
        return secretaireService.save(dto);
    }

    @Override
    public SecretaireDto findById(Integer id) {
        return secretaireService.findById(id);
    }

    @Override
    public List<SecretaireDto> findAll() {
        return secretaireService.findAll();
    }

    @Override
    public void delete(Integer id) {

    }
}