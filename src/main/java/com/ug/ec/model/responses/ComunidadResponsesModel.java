
package com.ug.ec.model.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ug.ec.domain.Grupo;
import com.ug.ec.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ComunidadResponsesModel {
    
    private Integer idComunidad;    
    private String comunidad;   
    private String imagen;    
    private Boolean estatus;    
    private Grupo grupo; 
    @JsonIgnore
    private List<Persona> persona = new ArrayList<>();
    
}
