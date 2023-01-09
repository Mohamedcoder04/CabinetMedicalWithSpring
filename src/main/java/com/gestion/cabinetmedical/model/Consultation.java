package com.gestion.cabinetmedical.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data @NoArgsConstructor
@AllArgsConstructor @Entity
@EqualsAndHashCode(callSuper = true)
public class Consultation extends AbstractEntity {

    @Column(name = "motif")
    private String motif;

    @Column(name = "date")
    private Instant date;

    @Column(name = "tarif")
    private Double tarif;

    @Column(name = "observation")
    private String observation;

    @OneToOne(mappedBy = "consultation")
    private Ordonnance ordonnance;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
