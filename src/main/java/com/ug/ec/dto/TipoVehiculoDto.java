
package com.ug.ec.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ug.ec.domain.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
public class TipoVehiculoDto implements Serializable{
    
    private Integer idTipoVehiculo;    
    private String nombreTipoVehiculo;
    private List<Persona> persona = new ArrayList<>();

    private static final long serialVersionUID = 1L;
}
