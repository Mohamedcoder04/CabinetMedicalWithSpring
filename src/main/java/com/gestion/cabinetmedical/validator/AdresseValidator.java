package com.gestion.cabinetmedical.validator;

import com.gestion.cabinetmedical.dto.AdresseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdresseValidator {

    public static List<String> validate(AdresseDto adresse) {
        List<String> errors = new ArrayList<>();
        if(adresse == null){
            errors.add("Veuillez remplir les données de l'adresse");
            errors.add("Veuillez remplir l'adresse1");
            errors.add("Veuillez remplir le code postal");
            errors.add("Veuillez remplir la ville");
            errors.add("Veuillez remplir le pays");
            return errors;
        }
        if(!StringUtils.hasLength(adresse.getAdresse1())){
            errors.add("Veuillez remplir l'adresse1");
        }
        if(!StringUtils.hasLength(adresse.getCodePostal())){
            errors.add("Veuillez remplir le code postal");
        }

        if(!StringUtils.hasLength(adresse.getVille())){
            errors.add("Veuillez remplir la ville");
        }

        if(!StringUtils.hasLength(adresse.getAdresse1())){
            errors.add("Veuillez remplir le pays");
        }

        return errors;

    }
}
