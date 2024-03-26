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

@JsonIdentityInfo(scope = Comunidad.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idComunidad")
@Data
@Entity
@Table(name = "tb_comunidad")
public class Comunidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomunidad")
    private Integer idComunidad;

    @Column(nullable = false)
    private String comunidad;

    @Column(name = "imagen")
    private String imagen;
    @Column(name = "estatus")
    private Boolean estatus;


   
    @ManyToOne
    @JoinColumn(name = "idgrupo")
    private Grupo grupo;

//    @JsonIgnore
//    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Persona> persona = new ArrayList<>();

    private static final long serialVersionUID = 1L;

}
