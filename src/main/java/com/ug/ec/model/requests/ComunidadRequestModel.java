
package com.ug.ec.model.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ug.ec.domain.Grupo;
import com.ug.ec.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ComunidadRequestModel {
    private String comunidad;   
    private String imagen;    
    private Boolean estatus;  
    
    private Grupo grupo;   
    @JsonIgnore
    private List<Persona> persona = new ArrayList<>();
}
