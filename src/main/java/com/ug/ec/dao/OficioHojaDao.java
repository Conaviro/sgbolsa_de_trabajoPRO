
package com.ug.ec.dao;

import com.ug.ec.domain.OficioHoja;
import com.ug.ec.domain.OficioHojaKey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OficioHojaDao extends JpaRepository<OficioHoja, OficioHojaKey> {
    @Query("SELECT ofh FROM OficioHoja ofh "
            + " INNER JOIN HojaVida ho on ofh.id.idHojaVida = ho.idHojaVida "
             + " WHERE ho.persona.idPersona= :idPersona" )
     List<OficioHoja> findByOfiHojaPersona(Long idPersona);
}
