
package com.ug.ec.dto;

import com.ug.ec.domain.HojaVida;
import com.ug.ec.domain.Oficio;
import com.ug.ec.domain.OficioHojaKey;
import java.io.Serializable;
import lombok.Data;

@Data
public class OficioHojaDto implements Serializable {
    OficioHojaKey  id;       
    String descripcion;
    OficioDto oficio;
    private static final long serialVersionUID = 1L;
}
