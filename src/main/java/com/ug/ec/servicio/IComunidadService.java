
package com.ug.ec.servicio;

import com.ug.ec.domain.Comunidad;
import com.ug.ec.dto.ComunidadDto;
import java.util.List;
import java.util.Optional;


public interface IComunidadService {
    public List<ComunidadDto> findAll();
    public void save(Comunidad comunidad);
    public ComunidadDto findComunidad(Comunidad comunidad);
    public void deleteComunidad(Comunidad comunidad);
    public ComunidadDto uptadeComunidad(Comunidad comunidad);
    public Optional<Comunidad> findComunidadById(Integer idComunidad);
    public void deleteComunidad(Integer id);
    public ComunidadDto findById(Integer id);
}
