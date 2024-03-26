

package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Persona;
import com.ug.ec.domain.Experiencia;
import com.ug.ec.domain.Estudio;
import com.ug.ec.domain.Idioma;
import com.ug.ec.domain.Referencia;
import com.ug.ec.domain.Conocimiento;
import com.ug.ec.domain.Oficio;
import java.math.BigDecimal;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class HojaVidaDto implements Serializable{

    

    private Long idHojaVida;    
    private String objetivo;
    private BigDecimal salario;
    private int tipoPostulante;
    private Persona persona;
    
    private static final long serialVersionUID = 1L;
//    private Set<Experiencia> experiencia = new HashSet<Experiencia>();
//    private Set<Estudio> estudio = new HashSet<Estudio>();
//    private Set<Idioma> idioma = new HashSet<Idioma>();
//    private Set<Referencia> referencia = new HashSet<Referencia>();
//    private Set<Conocimiento> conocimiento = new HashSet<Conocimiento>();
//    private Set<Oficio> oficio = new HashSet<Oficio>();
}
