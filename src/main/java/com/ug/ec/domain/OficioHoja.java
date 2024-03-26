
package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@JsonIdentityInfo(scope = OficioHoja.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@Entity
@Table(name = "oficio_has_tb_hojavida")
public class OficioHoja implements Serializable{
    
    @EmbeddedId
    OficioHojaKey  id;       
    String descripcion;
    private static final long serialVersionUID = 1L;
}
