package com.ug.ec.dto;

import com.ug.ec.domain.Comunidad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class GrupoDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer idGrupo;
    
    private String nombreGrupo;

    //private List<Comunidad> comunidad = new ArrayList<>();
}