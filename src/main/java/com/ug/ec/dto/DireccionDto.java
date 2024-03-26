
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.TipoDireccion;
import com.ug.ec.domain.Persona;
import com.ug.ec.domain.Provincia;
import com.ug.ec.domain.Canton;
import com.ug.ec.domain.DireccionPk;
import com.ug.ec.domain.Parroquia;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
public class DireccionDto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    //private Integer idDireccion;
    private DireccionDtoPk llave;
    private int idTipoDomicilio;
    private String callePrincipal;
    private String numeroCasa;
    private String calleSecundaria;
    private String barrio;
    private float ubicacionLat;
    private float ubicacionIng;
    private String telefonoDomicilioUno;
    private String extUno;
    private String telefonoDomicilioDos;
    private String extDos;
    private String celular;
    private String webPage;
    private TipoDireccion tipoDireccion;
    //private Persona persona;
    private Parroquia parroquia;
    private Canton canton;
    private Provincia provincia;
    

}
