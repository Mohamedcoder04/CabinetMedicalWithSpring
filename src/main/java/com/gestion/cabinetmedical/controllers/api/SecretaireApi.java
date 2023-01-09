package com.gestion.cabinetmedical.controllers.api;

import com.gestion.cabinetmedical.dto.MedecinDto;
import com.gestion.cabinetmedical.dto.SecretaireDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestion.cabinetmedical.utils.Constantes.ROUTE_MEDECIN;
import static com.gestion.cabinetmedical.utils.Constantes.ROUTE_SECRETAIRE;

public interface SecretaireApi {
    @PostMapping(value = ROUTE_SECRETAIRE+"/creation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    SecretaireDto save(@RequestBody SecretaireDto dto);

    @GetMapping(value = ROUTE_SECRETAIRE+"/find/{idMedecin}")
    SecretaireDto findById(@PathVariable("idMedecin") Integer id);

    @GetMapping(value = ROUTE_SECRETAIRE+"/liste", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SecretaireDto> findAll();

    @DeleteMapping(value = ROUTE_SECRETAIRE+"/delete/{idMedecin}")
    void delete(@PathVariable("idMedecin") Integer id);
}
