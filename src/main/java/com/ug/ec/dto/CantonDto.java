
package com.ug.ec.dto;

import com.ug.ec.domain.Provincia;
import com.ug.ec.domain.Direccion;
import com.ug.ec.domain.Parroquia;
import com.ug.ec.domain.Oferta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class CantonDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idCanton;
    private String nombreCanton;
    private Provincia provincia;
    private List<Direccion> direccion = new ArrayList<>();
    private List<Parroquia> parroquia = new ArrayList<>();
    private List<Oferta> oferta = new ArrayList<>();
}
