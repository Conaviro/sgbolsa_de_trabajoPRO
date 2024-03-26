
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Estudio;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class PaisDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String nombrePais;
    private Integer idPais;
    private List<Estudio> estudio = new ArrayList<>();
}
