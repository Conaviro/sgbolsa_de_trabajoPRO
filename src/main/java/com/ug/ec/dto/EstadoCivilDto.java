
package com.ug.ec.dto;


import com.ug.ec.domain.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class EstadoCivilDto implements Serializable {
    
    private Integer idEstadoCivil;    
    private String nombreEstadoCivil;    
    private List<Persona> persona = new ArrayList<>();

    private static final long serialVersionUID = 1L;
}
