
package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@JsonIdentityInfo(scope = Oficio.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idOficio")
@Data
@Entity
@Table(name = "oficio")
public class Oficio implements Serializable{
    
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoficio")
    private Integer idOficio;
    
    String descripcion;
    
   // @JsonIgnore
    @ManyToMany
    @JoinTable(name = "oficio_has_tb_hojavida",
            joinColumns = @JoinColumn(name = "idoficio", referencedColumnName = "idoficio", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false))
    private Set<HojaVida> hojaVida = new HashSet<HojaVida>();
    
     private static final long serialVersionUID = 1L;
    
}
