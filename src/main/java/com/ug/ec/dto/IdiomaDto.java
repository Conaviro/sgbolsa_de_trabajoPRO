
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.HojaVida;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class IdiomaDto implements Serializable{

     private static final long serialVersionUID = 1L;

     private Integer idIdioma;
     private String nombreIdioma;
     private short nivelIdioma;
     private Set<HojaVida> hojaVida = new HashSet<HojaVida>();
}
