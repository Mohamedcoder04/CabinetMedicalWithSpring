package com.gestion.cabinetmedical.controllers.api;

import com.gestion.cabinetmedical.dto.PatientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestion.cabinetmedical.utils.Constantes.ROUTE_PATIENT;

public interface PatientApi {
    @PostMapping(value = ROUTE_PATIENT+"/creation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PatientDto save(@RequestBody PatientDto dto);

    @GetMapping(value = ROUTE_PATIENT+"/find/{idpatient}", produces = MediaType.APPLICATION_JSON_VALUE)
    PatientDto findById(@PathVariable("idpatient") Integer id);

    @GetMapping(value = ROUTE_PATIENT+"/liste", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PatientDto> findAll();

    @DeleteMapping(value = ROUTE_PATIENT+"/delete/{idpatient}")
    void delete(@PathVariable("idpatient") Integer id);
}
