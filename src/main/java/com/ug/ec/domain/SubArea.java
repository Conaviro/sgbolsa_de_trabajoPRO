package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@JsonIdentityInfo(scope = SubArea.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSubArea")
@Data
@Entity
@Table(name = "tb_subarea")
public class SubArea implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubarea")
    private int idSubArea;

    @Column(name = "nombresubarea")
    private String nombreSubArea;
    
    @ManyToOne
    @JoinColumn(name = "idarea")
    private Area area;

    private static final long serialVersionUID = 1L;

}