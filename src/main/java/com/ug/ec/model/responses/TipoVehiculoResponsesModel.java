
package com.ug.ec.model.responses;

import com.ug.ec.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class TipoVehiculoResponsesModel {
    
    private Integer idTipoVehiculo;    
    private String nombreTipoVehiculo;
    private List<Persona> persona = new ArrayList<>();
    
}
