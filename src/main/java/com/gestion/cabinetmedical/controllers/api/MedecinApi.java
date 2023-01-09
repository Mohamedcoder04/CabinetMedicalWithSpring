package com.gestion.cabinetmedical.controllers.api;

import com.gestion.cabinetmedical.dto.MedecinDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestion.cabinetmedical.utils.Constantes.ROUTE_MEDECIN;

public interface MedecinApi {
    @PostMapping(value = ROUTE_MEDECIN+"/creation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MedecinDto save(@RequestBody MedecinDto dto);

    @GetMapping(value = ROUTE_MEDECIN+"/find/{idMedecin}")
    MedecinDto findById(@PathVariable("idMedecin") Integer id);

    @GetMapping(value = ROUTE_MEDECIN+"/liste", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MedecinDto> findAll();

    @DeleteMapping(value = ROUTE_MEDECIN+"/delete/{idMedecin}")
    void delete(@PathVariable("idMedecin") Integer id);
}
