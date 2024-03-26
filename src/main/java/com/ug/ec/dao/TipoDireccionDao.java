package com.ug.ec.dao;

import com.ug.ec.domain.TipoDireccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface TipoDireccionDao extends JpaRepository<TipoDireccion, Integer>{

}