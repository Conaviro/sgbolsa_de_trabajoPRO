package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@JsonIdentityInfo(scope = Persona.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPersona")
@Data
@Entity
@Table(name = "tb_persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private Long idPersona;

    @Column(nullable = false)
    private String identificacion;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    private String foto;

    @Temporal(TemporalType.DATE)  
    @Past      
    @DateTimeFormat(pattern = "yyyy-MM-dd")    
    @Column(name = "fechanacimiento", nullable = false)
    private Date fechaNacimiento;

    //, unique = true
    @Column(nullable = false, unique = true)
    private String email;
    
    private Short viajar;
    private Short discapacidad;
    private short estatus;


    
// @JsonBackReference
    
    @ManyToOne
    @JoinColumn(name = "idestadocivil")   
    private EstadoCivil estadoCivil;
    
    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Genero genero;
    
    @ManyToOne
    @JoinColumn(name = "idtipoidentificacion")
    private TipoIdentificacion tipoIdentificacion;
    
    @ManyToOne
    @JoinColumn(name = "idtipolicencia")
    private TipoLicencia licencia;
    
    @ManyToOne
    @JoinColumn(name = "idtipovehiculo")
    private TipoVehiculo tipoVehiculo;
    
    @ManyToOne
    @JoinColumn(name = "idcomunidad")
    private Comunidad comunidad;
    
//    @OneToMany(mappedBy = "persona")
//    private List<Direccion> direccion;
    
    
    

    
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "tb_persona_has_tb_oferta",
            joinColumns = @JoinColumn(name = "idpersona", referencedColumnName = "idpersona"),
            inverseJoinColumns = @JoinColumn(name = "idoferta", referencedColumnName = "idoferta"))
    private Set<Oferta> oferta = new HashSet<Oferta>();

    private static final long serialVersionUID = 1L;

}
