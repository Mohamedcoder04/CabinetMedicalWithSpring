package com.gestion.cabinetmedical.validator;

import com.gestion.cabinetmedical.dto.MedecinDto;
import com.gestion.cabinetmedical.dto.RendezVousDto;
import com.gestion.cabinetmedical.model.Secretaire;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RendezVousValidator {
    public static List<String> validate(RendezVousDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez remplir les données du rendez-vous");
            errors.add("Veuillez remplir une date pour un rendez-vous");
            return errors;
        }

        if(dto.getDate() == null){
            errors.add("Veuillez remplir une date pour un rendez-vous");
        }
        errors.addAll(PatientValidator.validate(dto.getPatient()));
        errors.addAll(MedecinValidator.validate(dto.getMedecin()));
        errors.addAll(SecretaireValidator.validate(dto.getSecretaire()));
        return errors;
    }
}
