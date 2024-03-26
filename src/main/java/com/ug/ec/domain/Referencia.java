package com.ug.ec.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@JsonIdentityInfo(scope = Referencia.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idReferencia")
@Data
@Entity
@Table(name = "tb_referencia")
public class Referencia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreferencia")
    private Integer idReferencia;

    @Column(name = "nombrereferencia")
    private String nombreReferencia;

    @Column(name = "telefonoreferencia")
    private String telefonoReferencia;
    
    //@JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_referencia_has_tb_hojavida",
            joinColumns = @JoinColumn(name = "idreferencia", referencedColumnName = "idreferencia", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "idhojavida", referencedColumnName = "idhojavida", insertable = false, updatable = false))
    private Set<HojaVida> hojaVida = new HashSet<HojaVida>();

    private static final long serialVersionUID = 1L;

}
