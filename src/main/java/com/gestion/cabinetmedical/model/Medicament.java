package com.gestion.cabinetmedical.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor @Entity
@EqualsAndHashCode(callSuper = true)
public class Medicament extends AbstractEntity {
    @Column(name = "nom")
    private String nom;

    @Column(name = "type")
    private String type;

    @Column(name = "details")
    private String details;

    @ManyToMany(mappedBy = "medicaments")
    private List<Ordonnance> ordonnances;
}
