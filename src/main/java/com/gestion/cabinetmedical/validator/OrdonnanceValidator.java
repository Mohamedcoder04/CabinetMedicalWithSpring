package com.gestion.cabinetmedical.validator;

import com.gestion.cabinetmedical.dto.ConsultationDto;
import com.gestion.cabinetmedical.dto.OrdonnanceDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrdonnanceValidator {

    public static List<String> validate(OrdonnanceDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez remplir les données du rendez vous");
            errors.add("Veuillez remplir la date de l'ordonnance ");
            return errors;
        }

        if(dto.getDate() == null){
            errors.add("Veuillez remplir la date de l'ordonnance ");
        }
        errors.addAll(ConsultationValidator.validate(dto.getConsultation()));
        return errors;
    }
}
