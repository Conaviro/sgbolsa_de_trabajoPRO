package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
@JsonIdentityInfo(scope = Empresa.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEmpresa")
@Data
@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempresa")
    private Integer idEmpresa;

    @Column(name = "nombreempresa")
    private String nombreEmpresa;

    @Column(name = "rasonsocial")
    private String rasonSocial;

    @Column(name = "logo")
    private String logo="no-image.png";;

    @Column(name = "paginaweb")
    private String paginaWeb;
    

    /*

    /*@JsonIgnore
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contacto> contacto = new ArrayList<>();  
    
    @JsonIgnore
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Oferta> oferta = new ArrayList<>(); 
    */
    

    
    private static final long serialVersionUID = 1L;
}