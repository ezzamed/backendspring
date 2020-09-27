package org.sid.campagnevac.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Vaccination implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date_vaccination;
    private double longiude,latitude;
    private Integer nombre_enfant;
    private String tranche_age;
    @ManyToOne
    private Campagne campagne;
    @ManyToOne
    private Moughataa moughataa;
    @ManyToOne
    private AppUser user;
    @ManyToOne
    private Vaccin vaccin;
}

