package org.sid.campagnevac.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Campagne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private String statut;
    @ManyToOne
    private Demographie demographie;
    @OneToMany(mappedBy = "campagne", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Vaccination> vaccinations;
}
