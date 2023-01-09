package com.gestion.cabinetmedical.controllers.api;

import com.gestion.cabinetmedical.dto.MedicamentDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestion.cabinetmedical.utils.Constantes.ROUTE_MEDICAMENT;

public interface MedicamentApi {

    @PostMapping(value = ROUTE_MEDICAMENT + "/creation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MedicamentDto save(@RequestBody MedicamentDto dto);

    @GetMapping(value = ROUTE_MEDICAMENT+"/find/{idmedicament}", produces = MediaType.APPLICATION_JSON_VALUE)
    MedicamentDto findById(@PathVariable("idmedicament") Integer id);

    @GetMapping(value = ROUTE_MEDICAMENT+"/liste", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MedicamentDto> findAll();

    @DeleteMapping(value = ROUTE_MEDICAMENT+"/delete/{idmedicament}")
    void delete(@PathVariable("idmedicament") Integer id);

}

