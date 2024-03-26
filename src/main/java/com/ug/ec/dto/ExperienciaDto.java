
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.HojaVida;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class ExperienciaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idExperiencia;
    private String descripcion;
    private String tiempoExperiencia;
   // private Set<HojaVida> hojaVida = new HashSet<HojaVida>();
    
}
