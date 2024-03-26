package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@JsonIdentityInfo(scope = Nivel.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idNivel")
@Data
@Entity
@Table(name = "tb_nivel")
public class Nivel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel")
    private Integer idNivel;

    @Column(name = "nivelestudio")
    private short nivelEstudio;
    
    @ManyToOne
    @JoinColumn(name = "idestudio")
    private Estudio estudio;
    
    private static final long serialVersionUID = 1L;
}