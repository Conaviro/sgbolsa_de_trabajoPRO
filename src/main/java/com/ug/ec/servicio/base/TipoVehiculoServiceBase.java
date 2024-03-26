
package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.ug.ec.dao.TipoVehiculoDao;
import com.ug.ec.domain.TipoVehiculo;
import com.ug.ec.dto.TipoVehiculoDto;
import com.ug.ec.servicio.ITipoVehiculoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoVehiculoServiceBase implements ITipoVehiculoService {
    
    @Autowired 
    private TipoVehiculoDao tipovehiculoDao;
    
    @Autowired
    ModelMapper mapper;
        
    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoVehiculoDto> findAll() {
        
        List<TipoVehiculoDto> tipoVehiculoDtos = gson.fromJson(gson.toJson(tipovehiculoDao.findAll()), ArrayList.class);
/*
        for (TipoVehiculo tipoVehiculo : tipovehiculoDao.findAll()) {
            TipoVehiculoDto objDto = mapper.map(tipoVehiculo, TipoVehiculoDto.class);
            tipoVehiculoDtos.add(objDto);
        }
*/
         return tipoVehiculoDtos;
    }

    @Override
    public TipoVehiculoDto save(TipoVehiculoDto tipoVehiculo) {
               
        TipoVehiculo tipovehiculoEnty = mapper.map(tipoVehiculo, TipoVehiculo.class);
        tipovehiculoDao.save(tipovehiculoEnty);
        TipoVehiculoDto objDto = mapper.map(tipovehiculoEnty, TipoVehiculoDto.class);

        return objDto;

    }

    @Override
    @Transactional(readOnly = true)
    public TipoVehiculoDto findTipoVehiculo(TipoVehiculoDto tipoVehiculo) {
        
        TipoVehiculo tipovehiculoEnty = tipovehiculoDao.findById(tipoVehiculo.getIdTipoVehiculo() ).orElse(null);
        TipoVehiculoDto objDto = gson.fromJson(gson.toJson(tipovehiculoEnty), TipoVehiculoDto.class);

        return objDto;
        
    }

    @Override
    @Transactional
    public void deleteTipoVehiculo(TipoVehiculo tipovehiculo) {
        tipovehiculoDao.delete(tipovehiculo);
    }

    @Override
    @Transactional
    public TipoVehiculoDto uptadeTipoVehiculo(TipoVehiculo tipoVehiculo) {
                
        TipoVehiculo tipoVehiculoEnty = (TipoVehiculo)tipovehiculoDao.save(tipoVehiculo);
        TipoVehiculoDto objDto = gson.fromJson(gson.toJson(tipoVehiculoEnty), TipoVehiculoDto.class);//

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoVehiculo> findTipoVehiculoById(Integer idTipoVehiculo) {
        return (Optional<TipoVehiculo>)tipovehiculoDao.findById(idTipoVehiculo);
    }

    @Override
    @Transactional
    public void deleteTipoVehiculo(Integer id) {
        tipovehiculoDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public TipoVehiculoDto findById(Integer id) {
       
        TipoVehiculo tipovehiculoEnty = tipovehiculoDao.findById(id ).orElse(null);
        TipoVehiculoDto objDto = gson.fromJson(gson.toJson(tipovehiculoEnty), TipoVehiculoDto.class);

        return objDto;
    }
}
