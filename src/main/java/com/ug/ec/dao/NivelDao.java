package com.ug.ec.dao;

import com.ug.ec.domain.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NivelDao extends JpaRepository<Nivel, Integer>{
    
}
