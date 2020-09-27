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
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Moughataa implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7878117718100163878L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String moughataaname;
    @OneToMany(mappedBy = "moughataa")
    private Collection<Enquete> enquetes;
    @ManyToOne
    private Wilaya wilaya;
    @OneToMany(mappedBy = "moughataa")
    @JsonIgnore
    private Collection<Vaccination> vaccinations;
}
