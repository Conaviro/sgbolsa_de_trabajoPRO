
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Empresa;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ContactoDto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer idContacto;
    private String identificacion;
    private String nombre;
    private String apellido;
    private Empresa empresa;
}
