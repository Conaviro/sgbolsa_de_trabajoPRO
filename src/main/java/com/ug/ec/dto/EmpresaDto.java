package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Contacto;
import com.ug.ec.domain.Oferta;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class EmpresaDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer idEmpresa;
    private String nombreEmpresa;
    private String rasonSocial;
    private byte[] logo;
    private String paginaWeb;
    private List<Contacto> contacto = new ArrayList<>();
    private List<Oferta> oferta = new ArrayList<>(); 
}
