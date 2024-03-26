
package com.ug.ec.model.responses;

import com.ug.ec.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class TipoLicenciaResponsesModel {
    private int idTipoLicencia;    
    private String nombreTipoLicencia;    
    private List<Persona> persona = new ArrayList<>();
}
