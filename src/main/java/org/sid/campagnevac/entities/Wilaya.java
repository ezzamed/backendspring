package org.sid.campagnevac.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString

public class Wilaya {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String name;
    @OneToMany(mappedBy = "wilaya",fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Moughataa> moughataas;
}
