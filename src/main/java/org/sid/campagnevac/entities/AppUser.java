package org.sid.campagnevac.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class AppUser implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean actived;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Collection<Vaccination> vaccinations;
    
}
