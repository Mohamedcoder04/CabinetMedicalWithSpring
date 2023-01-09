package com.gestion.cabinetmedical.validator;

import com.gestion.cabinetmedical.dto.ConsultationDto;
import com.gestion.cabinetmedical.dto.MedecinDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MedecinValidator {
    public static List<String> validate(MedecinDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez remplir les données du medecin");
            errors.add("Veuillez remplir le nom du medecin");
            errors.add("Veuillez remplir le prenom du medecin");
            errors.add("Veuillez remplir l'email du medecin");
            errors.add("Veuillez remplir le password du medecin");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez remplir le nom du medecin");
        }

        if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez remplir le prenom du medecin");
        }

        if(!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez remplir l'email du medecin");
        }
        if(!StringUtils.hasLength(dto.getPassword())){
            errors.add("Veuillez remplir le password du medecin");
        }
        return errors;
    }
}
