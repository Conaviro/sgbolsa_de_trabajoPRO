package com.ug.ec.dao;

import com.ug.ec.domain.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IdiomaDao extends JpaRepository<Idioma, Integer>{

}