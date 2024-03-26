
package com.ug.ec.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class DireccionDtoPk implements Serializable{
    
    private Long idPersona;
    private int idtipoDireccion;  

    
    private static final long serialVersionUID = 1L;
}
