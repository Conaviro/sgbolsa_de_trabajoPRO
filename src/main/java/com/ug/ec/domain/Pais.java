package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@JsonIdentityInfo(scope = Pais.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPais")
@Entity
@Table(name = "tb_pais")
@Data
public class Pais implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) 
    @Column(name = "idpais")
    private Integer idPais;

    @Column(name = "nombrepais")
    private String nombrePais;
    
    

//    
//    @ManyToOne
//    @JoinColumn(name = "idestudio")
//    private Estudio estudio;
    
//    @JsonIgnore
//    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Provincia> provincia = new ArrayList<>();
    
    
 /*   @JsonIgnore
    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudio> estudio = new ArrayList<>();
 */ 
   
    private static final long serialVersionUID = 1L;
}