
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Estudio;
import lombok.Data;

@Data
public class NivelDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Integer idNivel;    
    private short nivelEstudio;
    private Estudio estudio;
    
}
