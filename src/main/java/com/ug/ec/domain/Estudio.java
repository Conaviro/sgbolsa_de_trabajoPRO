package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@JsonIdentityInfo(scope = Estudio.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEstudio")
@Data
@Entity
@Table(name = "tb_estudio")
public class Estudio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestudio")
    private Integer idEstudio;

    @Column(name = "institucion")
    private String institucion;

    @Column(name = "titulo")
    private String titulo;


    @ManyToOne
    @JoinColumn(name = "idpais")
    @JsonBackReference
    private Pais pais;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "tb_estudio_has_tb_hojavida",
            joinColumns = @JoinColumn(name = "idestudio", referencedColumnName = "idestudio"), 
            inverseJoinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida"))
    private Set<HojaVida> hojaVida = new HashSet<HojaVida>();

    private static final long serialVersionUID = 1L;
}
