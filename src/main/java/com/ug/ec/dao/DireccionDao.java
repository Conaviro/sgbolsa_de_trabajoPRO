package com.ug.ec.dao;

import com.ug.ec.domain.Direccion;
import com.ug.ec.domain.DireccionPk;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface DireccionDao extends JpaRepository<Direccion, DireccionPk>{

    @Query("SELECT dir FROM Direccion dir WHERE dir.llave.idPersona= :idPersona" )
     List<Direccion> findByPersona(Long idPersona);
}
