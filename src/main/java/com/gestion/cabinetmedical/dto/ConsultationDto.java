package com.gestion.cabinetmedical.dto;


import com.gestion.cabinetmedical.model.Consultation;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ConsultationDto {
    private Integer id;
    private Instant date;
    private Double tarif;
    private String motif;
    private String observation;
    private OrdonnanceDto ordonnance;
    private MedecinDto medecin;
    private PatientDto patient;

    public static ConsultationDto fromEntity(Consultation consultation) {
        return ConsultationDto.builder()
                .id(consultation.getId())
                .date(consultation.getDate())
                .tarif(consultation.getTarif())
                .motif(consultation.getMotif())
                .observation(consultation.getObservation())
                .ordonnance(OrdonnanceDto.fromEntity(consultation.getOrdonnance()))
                .medecin(MedecinDto.fromEntity(consultation.getMedecin()))
                .patient(PatientDto.fromEntity(consultation.getPatient()))
                .build();
    }

    public static Consultation toEntity(ConsultationDto dto) {
        Consultation consultation = new Consultation();
        consultation.setId(dto.getId());
        consultation.setDate(dto.getDate());
        consultation.setTarif(dto.getTarif());
        consultation.setMotif(dto.getMotif());
        consultation.setObservation(dto.getObservation());
        consultation.setOrdonnance(OrdonnanceDto.toEntity(dto.getOrdonnance()));
        consultation.setMedecin(MedecinDto.toEntity(dto.getMedecin()));
        consultation.setPatient(PatientDto.toEntity(dto.getPatient()));
        return consultation;
    }
}
