package com.ug.ec.dao;

import com.ug.ec.domain.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface TipoIdentificacionDao extends JpaRepository<TipoIdentificacion, Integer>{

}