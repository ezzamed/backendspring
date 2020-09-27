package org.sid.campagnevac.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString


public class Enquete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nb011;
    private int nb1259;
    private int popvisee;
    @ManyToOne
    private Demographie demographie;
    @ManyToOne
    private Moughataa moughataa;
}
