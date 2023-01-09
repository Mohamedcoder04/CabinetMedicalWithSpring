package com.gestion.cabinetmedical.services.implimantation;

import com.gestion.cabinetmedical.dto.MedecinDto;
import com.gestion.cabinetmedical.dto.PatientDto;
import com.gestion.cabinetmedical.dto.SecretaireDto;
import com.gestion.cabinetmedical.exceptions.EntityNotFoundException;
import com.gestion.cabinetmedical.exceptions.ErrorCodes;
import com.gestion.cabinetmedical.exceptions.InvalidEntityException;
import com.gestion.cabinetmedical.repositories.MedecinRepository;
import com.gestion.cabinetmedical.repositories.PatientRepository;
import com.gestion.cabinetmedical.repositories.SecretaireRepository;
import com.gestion.cabinetmedical.services.PatientService;
import com.gestion.cabinetmedical.validator.PatientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private SecretaireRepository secretaireRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, SecretaireRepository secretaireRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.secretaireRepository = secretaireRepository;
    }

    @Override
    public PatientDto save(PatientDto dto) {
        List<String> errors = PatientValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("patient n'est pas valid");
            throw new InvalidEntityException("patient que vous avez saisi n'est pas valid", ErrorCodes.PATIENT_NOT_VALID);
        }
        MedecinDto medecinDto = MedecinDto.fromEntity(
                medecinRepository.findById(dto.getMedecin().getId()).orElseThrow(
                        () -> new EntityNotFoundException("aucun medecin n'a été trouvé avec l'ID "+ dto.getMedecin().getId(),
                                ErrorCodes.MEDECIN_NOT_FOUND)
                )
        );

        SecretaireDto secretaireDto = SecretaireDto.fromEntity(
                secretaireRepository.findById(dto.getSecretaire().getId()).orElseThrow(
                        ()-> new EntityNotFoundException("aucun secretaire n'a été trouvé avec l'ID "+ dto.getSecretaire().getId(),
                                ErrorCodes.SECRETAIRE_NOT_FOUND)
                )
        );

        return PatientDto.fromEntity(
                patientRepository.save(PatientDto.toEntity(dto))
        );
    }

    @Override
    public PatientDto findById(Integer id) {
        if(id == null){
            log.warn("");
            throw new EntityNotFoundException("l'id est NULL", ErrorCodes.PATIENT_NOT_FOUND);
        }
        return PatientDto.fromEntity(
                patientRepository.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException("aucun patient n'a été trouvé avec l'ID "+ id, ErrorCodes.PATIENT_NOT_FOUND)
                )
        );
    }

    @Override
    public List<PatientDto> findAll() {
        return patientRepository.findAll().stream()
                .map(PatientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

    }
}
