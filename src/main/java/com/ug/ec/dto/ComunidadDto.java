
package com.ug.ec.dto;

import com.ug.ec.domain.Grupo;
import com.ug.ec.domain.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ComunidadDto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer idComunidad;    
    private String comunidad;   
    private String imagen;    
    private Boolean estatus;    
    private Grupo grupo;    
   // private List<Persona> persona = new ArrayList<>();
}
