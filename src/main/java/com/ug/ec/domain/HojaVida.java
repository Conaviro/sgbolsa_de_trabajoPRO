package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;

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
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import lombok.Data;

@JsonIdentityInfo(scope = HojaVida.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idHojaVida")
@Data
@Entity
@Table(name = "tb_hojavida")
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class HojaVida implements Serializable {

    

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhojavida")
    private Long idHojaVida;

 

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "salario")
    private BigDecimal salario;

    @Column(name = "tipopostulante")
    private int tipoPostulante;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idpersona")
    private Persona persona;

    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "tb_experiencia_has_tb_hojavida",
            joinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "idexperiencia", referencedColumnName = "idexperiencia", insertable = false, updatable = false))
    private Set<Experiencia> experiencia = new HashSet<Experiencia>();
*/
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "tb_hojavida_has_tb_estudio",
            joinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "idestudio", referencedColumnName = "idestudio", insertable = false, updatable = false))
    private Set<Estudio> estudio = new HashSet<Estudio>();
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "tb_idioma_has_tb_hojavida",
            joinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "ididioma", referencedColumnName = "ididioma", insertable = false, updatable = false))
    private Set<Idioma> idioma = new HashSet<Idioma>();
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "tb_referencia_has_tb_hojavida",
            joinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "idreferencia", referencedColumnName = "idreferencia", insertable = false, updatable = false))
    private Set<Referencia> referencia = new HashSet<Referencia>();
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "tb_hojavida_has_tb_conocimiento",
            joinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "idconocimiento", referencedColumnName = "idconocimiento", insertable = false, updatable = false))
    private Set<Conocimiento> conocimiento = new HashSet<Conocimiento>();
    /*
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "oficio_has_tb_hojavida",
            joinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "idoficio", referencedColumnName = "idoficio", insertable = false, updatable = false))
    private Set<Oficio> oficio = new HashSet<Oficio>();
    */

    private static final long serialVersionUID = 1L;
    ///Experiencia
//    public Set<Experiencia> getExperiencia() {
//        return experiencia;
//    }
//
//    public void setExperiencia(Set<Experiencia> experiencia) {
//        this.experiencia = experiencia;
//    }
//
//    public void addExperiencia(Experiencia experiencia) {
//        this.experiencia.add(experiencia);
//    }
//
//    ///Estudio
//    public Set<Estudio> getEstudio() {
//        return estudio;
//    }
//
//    public void setEstudio(Set<Estudio> estudio) {
//        this.estudio = estudio;
//    }
//
//    public void addEstudio(Estudio estudio) {
//        this.estudio.add(estudio);
//    }

}
