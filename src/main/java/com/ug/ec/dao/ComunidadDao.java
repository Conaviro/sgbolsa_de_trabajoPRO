
package com.ug.ec.dao;

import com.ug.ec.domain.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;


public interface ComunidadDao extends JpaRepository<Comunidad, Integer>{
    
}
