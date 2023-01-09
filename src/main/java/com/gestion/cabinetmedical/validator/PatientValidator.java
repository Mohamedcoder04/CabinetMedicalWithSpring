package com.gestion.cabinetmedical.validator;

import com.gestion.cabinetmedical.dto.PatientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PatientValidator {
    public static List<String> validate(PatientDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez remplir les données du medecin");
            errors.add("Veuillez remplir le nom du patient");
            errors.add("Veuillez remplir le prenom du patient");
            errors.add("Veuillez remplir la date de naissance du patient");
            errors.add("Veuillez saisir un age valid pour le patient");
            errors.add("Veuillez remplir le téléphone du patient");
            errors.add("Veuillez saisir un sexe valid");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez remplir le nom du patient");
        }

        if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez remplir le prenom du patient");
        }
        if(dto.getDateNaissance() == null){
            errors.add("Veuillez remplir la date de naissance du patient");
        }
        if(dto.getAge() <= 0){
            errors.add("Veuillez saisir un age valid pour le patient");
        }
        if(!StringUtils.hasLength(dto.getTelephone())){
            errors.add("Veuillez remplir le téléphone du patient");
        }
        if(!StringUtils.hasLength(dto.getSexe()) ){
            errors.add("Veuillez saisir un sexe valid");
        }

        errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        errors.addAll(SecretaireValidator.validate(dto.getSecretaire()));
        errors.addAll(MedecinValidator.validate(dto.getMedecin()));
        return errors;
    }
}
