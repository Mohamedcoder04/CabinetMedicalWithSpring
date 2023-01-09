package com.gestion.cabinetmedical.controllers.api;

import com.gestion.cabinetmedical.dto.OrdonnanceDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestion.cabinetmedical.utils.Constantes.ROUTE_ORDONNANCE;

public interface OrdonnanceApi {
    @PostMapping(value = ROUTE_ORDONNANCE+"/creation" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    OrdonnanceDto save(@RequestBody OrdonnanceDto dto);

    @GetMapping(value = ROUTE_ORDONNANCE+"/find/{idordonnance}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrdonnanceDto findById(@PathVariable("idordonnance") Integer id);

    @GetMapping(value = ROUTE_ORDONNANCE+"/liste",produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrdonnanceDto> findAll();

    @DeleteMapping(value = ROUTE_ORDONNANCE+"/delete/{idordonnance}")
    void delete(@PathVariable("idordonnance") Integer id);
}
