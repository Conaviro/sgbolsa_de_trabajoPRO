package com.ug.ec.dao;

import com.ug.ec.domain.Experiencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaDao extends JpaRepository<Experiencia, Integer>{

}