package com.ug.ec.dao;

import com.ug.ec.domain.HojaVida;
import com.ug.ec.domain.OficioHoja;
import com.ug.ec.domain.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HojaVidaDao extends JpaRepository<HojaVida, Long>{

     @Query("SELECT ho FROM HojaVida ho WHERE ho.persona.idPersona= :idPersona" )
     Persona findByPersona(Long idPersona);
     
     @Query("SELECT ho FROM HojaVida ho WHERE ho.persona.idPersona= :idPersona" )
     HojaVida findByPersonaId(Long idPersona);
     
     
}