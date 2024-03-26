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

@JsonIdentityInfo(scope = Canton.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCanton")
@Data
@Entity
@Table(name = "tb_canton")
public class Canton implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcanton")
    private Integer idCanton;

    @Column(name = "nombrecanton")
    private String nombreCanton;
    

    @ManyToOne
    @JoinColumn(name = "idprovincia")
    private Provincia provincia;
    

//    @ManyToOne
//    @JoinColumn(name = "idoferta")
//    private Oferta oferta;
    /*
    @JsonIgnore
    @OneToMany(mappedBy = "canton", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Direccion> direccion = new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "canton", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parroquia> parroquia = new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "canton", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Oferta> oferta = new ArrayList<>();*/

    private static final long serialVersionUID = 1L;
}