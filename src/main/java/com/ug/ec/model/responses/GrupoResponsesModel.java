
package com.ug.ec.model.responses;

import com.ug.ec.domain.Comunidad;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class GrupoResponsesModel {
    private Integer idGrupo;
    
    private String nombreGrupo;

    private List<Comunidad> comunidad = new ArrayList<>();
}
