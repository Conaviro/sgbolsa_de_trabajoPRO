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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@JsonIdentityInfo(scope = TipoVehiculo.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTipoVehiculo")
@Data
@Entity
@Table(name = "tb_tipovehiculo")
@XmlRootElement
public class TipoVehiculo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipovehiculo")
    private Integer idTipoVehiculo;
    
    @Column(name = "nombretipovehiculo",nullable = false)
    private String nombreTipoVehiculo;

//    @JsonIgnore
//    @OneToMany(mappedBy = "tipoVehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Persona> persona = new ArrayList<>();

    private static final long serialVersionUID = 1L;
}