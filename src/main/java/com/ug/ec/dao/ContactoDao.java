package com.ug.ec.dao;

import com.ug.ec.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContactoDao extends JpaRepository<Contacto, Integer>{

}