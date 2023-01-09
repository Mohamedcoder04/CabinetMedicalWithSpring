package com.gestion.cabinetmedical.services;

import com.gestion.cabinetmedical.dto.SecretaireDto;

import java.util.List;

public interface SecretaireService {

    SecretaireDto save(SecretaireDto dto);

    SecretaireDto findById(Integer id);

    SecretaireDto findByEmail(String email);

    List<SecretaireDto> findAll();

    void delete(Integer id);
}
