package com.ug.ec.dao;

import com.ug.ec.domain.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface PaisDao extends JpaRepository<Pais, Integer>{

}