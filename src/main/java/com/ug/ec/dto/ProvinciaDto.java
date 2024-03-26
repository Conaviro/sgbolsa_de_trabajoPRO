
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Pais;
import com.ug.ec.domain.Direccion;
import com.ug.ec.domain.Canton;
import com.ug.ec.domain.Oferta;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ProvinciaDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private int idProvincia;
    private String nombreProvincia;
    private Pais pais;
//    private List<Direccion> direccion = new ArrayList<>();
//    private List<Canton> canton = new ArrayList<>();
//    private List<Oferta> oferta = new ArrayList<>();

}
