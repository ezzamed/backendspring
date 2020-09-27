package org.sid.campagnevac.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vaccin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_vaccin;
    @ManyToOne
    private Campagne campagne;
    @OneToMany(mappedBy = "vaccin", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Vaccination> vaccinations;

}

