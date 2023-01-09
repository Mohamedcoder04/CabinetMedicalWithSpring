package com.gestion.cabinetmedical.validator;

import com.gestion.cabinetmedical.dto.ConsultationDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ConsultationValidator {

    public static List<String> validate(ConsultationDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez remplir les données de la consultation");
            errors.add("Veuillez remplir un tarif valid");
            errors.add("Veuillez remplir le motif");
            errors.add("Veuillez remplir la date de la consultation");
            return errors;
        }
        if(dto.getTarif() <= 0){
            errors.add("Veuillez remplir un tarif valid");
        }
        if(!StringUtils.hasLength(dto.getMotif())){
            errors.add("Veuillez remplir le motif");
        }
        if(dto.getDate() == null){
            errors.add("Veuillez remplir la date de la consultation");
        }
        errors.addAll(MedecinValidator.validate(dto.getMedecin()));
        return errors;
    }
}
