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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@JsonIdentityInfo(scope = Grupo.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idGrupo")
@Data
@Entity
@Table(name = "tb_grupo")
public class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgrupo")
    private Integer idGrupo;

    @Column(name = "nombregrupo", nullable = false)
    private String nombreGrupo;


//    @JsonIgnore
//    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comunidad> comunidad = new ArrayList<>();
    
    private static final long serialVersionUID = 1L;

}