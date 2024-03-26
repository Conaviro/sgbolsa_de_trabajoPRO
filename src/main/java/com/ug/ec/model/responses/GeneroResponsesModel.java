
package com.ug.ec.model.responses;

import com.ug.ec.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class GeneroResponsesModel {
    private Integer idGenero;    
    private String nombreGenero;    
    private List<Persona> persona = new ArrayList<>();
}
