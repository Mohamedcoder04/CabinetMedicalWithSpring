package com.gestion.cabinetmedical.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor @Entity
@EqualsAndHashCode(callSuper = true)
public class Ordonnance extends AbstractEntity {
    @Column(name = "date")
    private Instant date;

    @ManyToMany
    @JoinTable(
            name = "ordonnance_medicament",
            joinColumns = @JoinColumn(name = "ordonnance_id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id")
    )
    private List<Medicament> medicaments;

    @OneToOne
    private Consultation consultation;
}
