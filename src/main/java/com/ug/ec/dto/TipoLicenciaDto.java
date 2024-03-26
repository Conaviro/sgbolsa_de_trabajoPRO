
package com.ug.ec.dto;


import com.ug.ec.domain.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class TipoLicenciaDto implements Serializable{
    
    private int idTipoLicencia;    
    private String nombreTipoLicencia;    
    private List<Persona> persona = new ArrayList<>();
    
    private static final long serialVersionUID = 1L;
    
}
