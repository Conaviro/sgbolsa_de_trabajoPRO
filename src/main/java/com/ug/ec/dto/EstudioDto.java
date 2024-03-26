
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Pais;
import com.ug.ec.domain.Nivel;
import com.ug.ec.domain.HojaVida;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class EstudioDto implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer idEstudio;
    private String institucion;
    private String titulo;
    private Pais pais;
    //private Set<HojaVida> hojaVida = new HashSet<HojaVida>();
    //private List<Nivel> nivel = new ArrayList<>();

}
