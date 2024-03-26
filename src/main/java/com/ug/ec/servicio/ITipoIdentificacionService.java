
package com.ug.ec.servicio;


import com.ug.ec.domain.TipoIdentificacion;
import com.ug.ec.dto.TipoIdentificacionDto;
import java.util.List;
import java.util.Optional;
public interface ITipoIdentificacionService {
    public List<TipoIdentificacionDto> findAll();

    public TipoIdentificacionDto save(TipoIdentificacionDto tipoidentificacion);

    public TipoIdentificacionDto findTipoIdentificacion(TipoIdentificacionDto tipoidentificacion);

    public void deleteTipoIdentificacion(TipoIdentificacion tipoidentificacion);

    public TipoIdentificacionDto uptadeTipoIdentificacion(TipoIdentificacion tipoidentificacion);

    public Optional<TipoIdentificacion> findTipoIdentificacionById(Integer idTipoIdentificacion);

    public void deleteTipoIdentificacion(Integer id);

    public TipoIdentificacionDto findById(Integer id);

}
