
package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.Data;

@Data
@Embeddable
public class DireccionPk implements Serializable{
    
    @Column(name = "idpersona")
    private Long idPersona;
    
    @Column(name = "idtipodireccion")
    private int idtipoDireccion;
    

    
    private static final long serialVersionUID = 1L;
    
}
