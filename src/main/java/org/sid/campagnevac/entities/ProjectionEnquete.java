package org.sid.campagnevac.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;

@Projection(name="e1",types={Enquete.class})
public interface ProjectionEnquete {
    public Long getId();
    public int getNb011();
    public int getNb1259();
    public int getPopvisee();
    public Demographie getDemographie();
    public Moughataa getMoughataa();

}
