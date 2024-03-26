package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;

@JsonIdentityInfo(scope = Direccion.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "llave")
@Data
@Entity
@Table(name = "tb_direccion")
public class Direccion implements Serializable {

    //@Id
    @EmbeddedId
    private DireccionPk llave;
    
//    @Column(name = "iddireccion")
//    private Integer idDireccion;

//    @Column(name = "idtipodomicilio")
//    private int idTipoDomicilio;

    @Column(name = "calleprincipal")
    private String callePrincipal;

    @Column(name = "numerocasa")
    private String numeroCasa;

    @Column(name = "callesecundaria")
    private String calleSecundaria;

    @Column(name = "barrio")
    private String barrio;

    @Column(name = "ubicacionlat")
    private float ubicacionLat;

    @Column(name = "ubicacioning")
    private float ubicacionIng;

    @Column(name = "telefonodomiciliouno")
    private String telefonoDomicilioUno;

    @Column(name = "extuno")
    private String extUno;
                    
    @Column(name = "telefonodomiciliodos")
    private String telefonoDomicilioDos;

    @Column(name = "extdos")
    private String extDos;

    @Column(name = "celular")
    private String celular;

    @Column(name = "webpage")
    private String webPage;

    

    
    //@JsonIgnore 
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("idPersona")
//    @JoinColumn(name = "idpersona")     
//    private Persona persona;
    
    //@JsonIgnore 
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("idTipoDireccion")
//    @JoinColumn(name = "idtipodireccion")
//    private TipoDireccion tipoDireccion;
    
   // @JsonIgnore 
   // @ManyToOne(fetch = FetchType.LAZY)
    
    
//    @ManyToOne
//    @JoinColumn(name = "idtipodireccion")
//    private TipoDireccion tipoDireccion;
    
//    @ManyToOne
//    @JoinColumn(name = "idpersona")
//    private Persona persona;
    
//      @OneToMany(mappedBy = "direccion")
//      private List<Persona> persona;
    
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name = "idpersona",referencedColumnName = "idpersona")
//   
//    })     
//    private Persona persona;
//    
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name = "idtipodireccion",referencedColumnName = "idtipodireccion")
//    })     
//    private TipoDireccion tipoDireccion; @JoinColumn(name = "idtipodireccion",referencedColumnName = "idtipodireccion")
 //(fetch=FetchType.LAZY)   
    
    @Transient
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "llave.idpersona",referencedColumnName = "idpersona")
        
    }) 
    private Persona persona;//List<Direccion> direccion;
    
    @Transient
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "llave.idtipodireccion",referencedColumnName = "idtipodireccion")
        
    }) 
    private TipoDireccion tipoDireccion;

    @ManyToOne
    @JoinColumn(name = "idparroquia")
    private Parroquia parroquia;

    @ManyToOne
    @JoinColumn(name = "idcanton")
    private Canton canton;

    @ManyToOne
    @JoinColumn(name = "idprovincia")
    private Provincia provincia;

    private static final long serialVersionUID = 1L;

}
