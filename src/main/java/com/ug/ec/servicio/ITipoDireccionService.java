
package com.ug.ec.servicio;
import com.ug.ec.domain.TipoDireccion;
import com.ug.ec.dto.TipoDireccionDto;
import java.util.List;
import java.util.Optional;

public interface ITipoDireccionService {
    
    public List<TipoDireccionDto> findAll();

    public void save(TipoDireccion tipodireccion);

    public TipoDireccionDto findTipoDireccion(TipoDireccion tipodireccion);

    public void deleteTipoDireccion(TipoDireccion tipodireccion);

    public TipoDireccionDto uptadeTipoDireccion(TipoDireccion tipodireccion);

    public Optional<TipoDireccion> findTipoDireccionById(Integer idTipoDireccion);

    public void deleteTipoDireccion(Integer id);

    public TipoDireccionDto findById(Integer id);

}
