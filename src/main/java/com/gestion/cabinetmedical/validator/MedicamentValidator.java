package com.gestion.cabinetmedical.validator;

import com.gestion.cabinetmedical.dto.ConsultationDto;
import com.gestion.cabinetmedical.dto.MedicamentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MedicamentValidator {
    public static List<String> validate(MedicamentDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez remplir les données du medicament");
            errors.add("Veuillez remplir le nom du médicament");
            errors.add("Veuillez remplir le type du médicament");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez remplir le nom du médicament");
        }
        if(!StringUtils.hasLength(dto.getType())){
            errors.add("Veuillez remplir le type du médicament");
        }

        return errors;
    }
}
