package com.gestion.cabinetmedical.controllers.api;

import com.gestion.cabinetmedical.dto.ConsultationDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestion.cabinetmedical.utils.Constantes.ROUTE_CONSULTATION;

public interface ConsultationApi {
    @PostMapping(value = ROUTE_CONSULTATION + "/creation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ConsultationDto save(@RequestBody ConsultationDto dto);

    @GetMapping(value = ROUTE_CONSULTATION + "/find/{idConsultation}", produces = MediaType.APPLICATION_JSON_VALUE)
    ConsultationDto findById(@PathVariable("idConsultation") Integer id);

    @GetMapping(value = ROUTE_CONSULTATION + "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ConsultationDto> findAll();

    @DeleteMapping(value = ROUTE_CONSULTATION + "/delete/{idMedecin}")
    void delete(@PathVariable("idMedecin") Integer id);
}
