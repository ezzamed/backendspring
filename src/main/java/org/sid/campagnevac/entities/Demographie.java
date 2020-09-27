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
public class Demographie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private int annee;
    @OneToMany(mappedBy = "demographie")
    private Collection<Enquete> enquetes;
    @OneToMany(mappedBy = "demographie", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Campagne> campagnes;
}
