package com.gestion.cabinetmedical.validator;

import com.gestion.cabinetmedical.dto.MedecinDto;
import com.gestion.cabinetmedical.dto.SecretaireDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SecretaireValidator {
    public static List<String> validate(SecretaireDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez remplir les données du secretaire");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez remplir le nom du secretaire");
        }

        if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez remplir le prenom du secretaire");
        }

        if(!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez remplir l'email du secretaire");
        }
        if(!StringUtils.hasLength(dto.getPassword())){
            errors.add("Veuillez remplir le password du secretaire");
        }
        return errors;
    }
}
