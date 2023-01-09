package com.gestion.cabinetmedical.services.implimantation;

import com.gestion.cabinetmedical.dto.ConsultationDto;
import com.gestion.cabinetmedical.dto.MedecinDto;
import com.gestion.cabinetmedical.dto.OrdonnanceDto;
import com.gestion.cabinetmedical.dto.PatientDto;
import com.gestion.cabinetmedical.exceptions.EntityNotFoundException;
import com.gestion.cabinetmedical.exceptions.ErrorCodes;
import com.gestion.cabinetmedical.exceptions.InvalidEntityException;
import com.gestion.cabinetmedical.repositories.ConsultationRepository;
import com.gestion.cabinetmedical.repositories.MedecinRepository;
import com.gestion.cabinetmedical.repositories.OrdonnanceRepository;
import com.gestion.cabinetmedical.repositories.PatientRepository;
import com.gestion.cabinetmedical.services.ConsultationService;
import com.gestion.cabinetmedical.validator.ConsultationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConsultationServiceImpl implements ConsultationService {

    private ConsultationRepository consultationRepository;
    private OrdonnanceRepository ordonnanceRepository;
    private MedecinRepository medecinRepository;
    private PatientRepository patientRepository;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository, OrdonnanceRepository ordonnanceRepository, MedecinRepository medecinRepository, PatientRepository patientRepository) {
        this.consultationRepository = consultationRepository;
        this.ordonnanceRepository = ordonnanceRepository;
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public ConsultationDto save(ConsultationDto dto) {
        List<String> errors = ConsultationValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("consultation n'est pas valid {}", dto);
            throw new InvalidEntityException("la consultation que vous avez saisi n'est pa valide",
                    errors, ErrorCodes.CONSULTATION_NOT_VALID);
        }

        PatientDto patientDto = PatientDto.fromEntity(
                patientRepository.findById(dto.getPatient().getId()).orElseThrow(
                        ()-> new EntityNotFoundException("aucun patient n'a été trouvé avec l'ID "+dto.getPatient().getId()
                                , ErrorCodes.PATIENT_NOT_FOUND)
                )
        );

        MedecinDto medecinDto = MedecinDto.fromEntity(
                medecinRepository.findById(dto.getMedecin().getId()).orElseThrow(
                        ()-> new EntityNotFoundException("aucun medecin n'a été trouvé avec l'ID"+dto.getMedecin().getId()
                                , ErrorCodes.MEDECIN_NOT_FOUND)
                )
        );

        OrdonnanceDto ordonnanceDto= OrdonnanceDto.fromEntity(
                ordonnanceRepository.findById(dto.getOrdonnance().getId()).orElseThrow(
                        ()-> new EntityNotFoundException("aucune ordonnance n'a été trouvé avec l'ID "+dto.getOrdonnance().getId(),
                                ErrorCodes.ORDONNANCE_NOT_FOUND)
                )
        );

        return ConsultationDto.fromEntity(
                consultationRepository.save(ConsultationDto.toEntity(
                        dto
                ))
        );
    }

    @Override
    public ConsultationDto findById(Integer id) {

        if (id == null) {
            log.warn("l'id que vous avez saisi est Null");
            throw new EntityNotFoundException("aucune consultation n'a un ID NULL", ErrorCodes.CONSULTATION_NOT_FOUND);
        }
        return ConsultationDto.fromEntity(
                consultationRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("aucune consultation n'a été trouvé par l'ID" + id,
                                ErrorCodes.CONSULTATION_NOT_FOUND)
                )
        );
    }

    @Override
    public List<ConsultationDto> findAll() {
        return consultationRepository.findAll().stream()
                .map(ConsultationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

    }
}
