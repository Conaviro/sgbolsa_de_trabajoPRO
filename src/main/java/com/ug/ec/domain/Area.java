package com.ug.ec.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

@JsonIdentityInfo(scope = Area.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idArea")
@Data
@Entity
@Table(name = "tb_area")
public class Area implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarea")
    private Integer idArea;

    @Column(name = "nombrearea")
    private String nombreArea;
    
    /*
    @JsonIgnore
    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Oferta> oferta = new ArrayList<>();
  
    @JsonIgnore
    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubArea> subArea = new ArrayList<>();

    */
   
    private static final long serialVersionUID = 1L;
}