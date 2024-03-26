package com.ug.ec.dao;

import com.ug.ec.domain.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EstadocivilDao extends JpaRepository<EstadoCivil, Integer>{

}