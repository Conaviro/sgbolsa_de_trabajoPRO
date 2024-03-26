
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Direccion;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class TipoDireccionDto {
    
    private static final long serialVersionUID = 1L;
    
    private int idTipoDireccion;
    private String nombreTipoDireccion;   
    private List<Direccion> direccion = new ArrayList<>();

}
