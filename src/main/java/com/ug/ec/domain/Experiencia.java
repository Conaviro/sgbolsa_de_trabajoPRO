package com.ug.ec.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

//@JsonIgnoreProperties(value={"hibernateLazyInitializer"}) --revisar07022024
@JsonIdentityInfo(scope = Experiencia.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idExperiencia")
@Data
@Entity
@Table(name = "tb_experiencia")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Experiencia implements Serializable{  
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idexperiencia")
    private Integer idExperiencia;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tiempoexperiencia")
    private String tiempoExperiencia;
    
    //@JsonIgnore
    
    @ManyToMany
    @JoinTable(name = "tb_experiencia_has_tb_hojavida",
           joinColumns = @JoinColumn(name = "idexperiencia", referencedColumnName = "idexperiencia", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false))
    private Set<HojaVida> hojaVida = new HashSet<HojaVida>();
    
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JsonBackReference
//    @JoinTable(name = "tb_experiencia_has_tb_hojavida",
//            joinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false),
//            inverseJoinColumns = @JoinColumn(name = "idexperiencia", referencedColumnName = "idexperiencia", insertable = false, updatable = false))
//    private Set<Experiencia> experiencia = new HashSet<Experiencia>();
// 
//    
   
    
    private static final long serialVersionUID = 1L;
    
    
   
    
} 
