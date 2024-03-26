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

@JsonIdentityInfo(scope = TipoLicencia.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTipoLicencia")
@Data
@Entity
@Table(name = "tb_tipolicencia")
public class TipoLicencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipolicencia")
    private int idTipoLicencia;

    @Column(name = "nombretipolicencia")
    private String nombreTipoLicencia;
    
//    @JsonIgnore
//    @OneToMany(mappedBy = "licencia", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Persona> persona = new ArrayList<>();
    
    private static final long serialVersionUID = 1L;

}

