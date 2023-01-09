package com.gestion.cabinetmedical.controllers.api;

import com.gestion.cabinetmedical.dto.RendezVousDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestion.cabinetmedical.utils.Constantes.ROUTE_RENDEZVOUS;


public interface RendezVousApi {

    @PostMapping(value = ROUTE_RENDEZVOUS + "/creation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RendezVousDto save(@RequestBody RendezVousDto dto);

    @GetMapping(value = ROUTE_RENDEZVOUS + "/find/{idrv}", produces = MediaType.APPLICATION_JSON_VALUE)
    RendezVousDto findById(@PathVariable("idrv") Integer id);

    @GetMapping(value = ROUTE_RENDEZVOUS + "/liste", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RendezVousDto> findAll();

    @DeleteMapping(value = ROUTE_RENDEZVOUS+"/delete/{idrv}")
    void delete(@PathVariable("idrv") Integer id);
}
