
package com.ug.ec.servicio;


import com.ug.ec.domain.TipoVehiculo;
import com.ug.ec.dto.TipoVehiculoDto;
import java.util.List;
import java.util.Optional;


public interface ITipoVehiculoService {
    public List<TipoVehiculoDto> findAll();
    public TipoVehiculoDto save(TipoVehiculoDto tipoVehiculo);
    public TipoVehiculoDto findTipoVehiculo(TipoVehiculoDto tipoVehiculo);
    public void deleteTipoVehiculo(TipoVehiculo tipoVehiculo);
    public TipoVehiculoDto uptadeTipoVehiculo(TipoVehiculo tipoVehiculo);
    public Optional<TipoVehiculo> findTipoVehiculoById(Integer idTipoVehiculoDto);
    public void deleteTipoVehiculo(Integer id);
    public TipoVehiculoDto findById(Integer id);
}
