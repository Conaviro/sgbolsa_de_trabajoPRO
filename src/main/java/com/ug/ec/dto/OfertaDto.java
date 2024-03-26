
package com.ug.ec.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.ug.ec.domain.Canton;
import com.ug.ec.domain.Provincia;
import com.ug.ec.domain.Empresa;
import com.ug.ec.domain.Persona;
import com.ug.ec.domain.Area;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class OfertaDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Long idOferta;
    private String tituloOferta;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPublicacion;
    private int tipoEmpleo;
    private double salario;
    private String lugar;
    private String detalle;
    private Integer destacado;
    private String estatus;
    private Canton canton;  
    private Provincia provincia;
    private Empresa empresa;
    private Area area;
    //private Set<Persona> persona = new HashSet<Persona>();

}
