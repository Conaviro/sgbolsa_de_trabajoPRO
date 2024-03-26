
package com.ug.ec.domain;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class OficioHojaKey implements Serializable{
    @Column(name = "idoficio")
    private Integer idOficio;
    @Column(name = "idhojavida")
    private Long idHojaVida;

    
    
    private static final long serialVersionUID = 1L;
}
