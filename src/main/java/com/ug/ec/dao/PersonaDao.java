package com.ug.ec.dao;

import com.ug.ec.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends JpaRepository<Persona, Long>{

}