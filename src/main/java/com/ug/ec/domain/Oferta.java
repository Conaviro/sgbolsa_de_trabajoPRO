package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@JsonIdentityInfo(scope = Oferta.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idOferta")
@Data
@Entity
@Table(name = "tb_oferta")
public class Oferta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoferta")
    private Long idOferta;

    

    @Column(name = "titulooferta")
    private String tituloOferta;

    @Temporal(TemporalType.DATE)  
    @Past      
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechapublicacion")
    private Date fechaPublicacion;

    


    @Column(name = "tipoempleo")
    private int tipoEmpleo;

    @Column(name = "salario")
    private double salario;

   
    
    
    
    @Column(name = "lugar")
    private String lugar;

    @Column(name = "detalle")
    private String detalle;
    
    @Column(name = "destacado")
    private Integer destacado;
    
    @Column(name = "estatus")
    private String estatus; // Valores [Creado, Aprobado, Eliminado].
    
    @ManyToOne
    @JoinColumn(name = "idcanton")
    private Canton canton;
    
    @ManyToOne
    @JoinColumn(name = "idprovincia")
    private Provincia provincia;
    
    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name = "idarea")
    private Area area;

    

    
    
    
    @ManyToMany
    @JoinTable(name = "tb_persona_has_tb_oferta",
            joinColumns = @JoinColumn(name = "idoferta", referencedColumnName = "idoferta"),
            inverseJoinColumns = @JoinColumn(name = "idpersona", referencedColumnName = "idpersona"))
    private Set<Persona> persona = new HashSet<Persona>();
    

    private static final long serialVersionUID = 1L;

}