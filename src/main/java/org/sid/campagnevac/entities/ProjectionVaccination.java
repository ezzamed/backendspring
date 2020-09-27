package org.sid.campagnevac.entities;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
@Projection(name="v1",types={Vaccination.class})
public interface ProjectionVaccination {
    public Long getId();
    public int getNombre();
    public Moughataa   getMoughataa ();
}
