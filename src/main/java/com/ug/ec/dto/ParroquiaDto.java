
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Canton;
import com.ug.ec.domain.Direccion;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ParroquiaDto implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private int idParroquia;
    private String nombreParroquia;
    private Canton canton;
    private List<Direccion> direccion = new ArrayList<>();
    

}
