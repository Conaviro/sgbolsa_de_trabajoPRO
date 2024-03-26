package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.ug.ec.dao.TipoIdentificacionDao;
import com.ug.ec.domain.TipoIdentificacion;
import com.ug.ec.dto.TipoIdentificacionDto;
import com.ug.ec.servicio.ITipoIdentificacionService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoIdentificacionServiceBase implements ITipoIdentificacionService {

    @Autowired
    private TipoIdentificacionDao tipoidentificacionDao;

    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    @Override
    @Transactional(readOnly = true)
    public List<TipoIdentificacionDto> findAll() {
        
        List<TipoIdentificacionDto> tipoIdentificacionDtos = gson.fromJson(gson.toJson(tipoidentificacionDao.findAll()), ArrayList.class);
/*
        List<TipoIdentificacionDto> tipoIdentificacionDtos = new ArrayList<>();

        for (TipoIdentificacion tipoIdentificacion : tipoidentificacionDao.findAll()) {
            TipoIdentificacionDto objDto = mapper.map(tipoIdentificacion, TipoIdentificacionDto.class);
            tipoIdentificacionDtos.add(objDto);
        }

        return tipoIdentificacionDtos;
*/
        return tipoIdentificacionDtos;
    }

    @Override
    @Transactional
    public TipoIdentificacionDto save(TipoIdentificacionDto tipoidentificacion) {

        TipoIdentificacion tipoIdentificacionEnty = mapper.map(tipoidentificacion, TipoIdentificacion.class);
        tipoidentificacionDao.save(tipoIdentificacionEnty);
        TipoIdentificacionDto objDto = mapper.map(tipoIdentificacionEnty, TipoIdentificacionDto.class);

        return objDto;

    }

    @Override
    @Transactional(readOnly = true)
    public TipoIdentificacionDto findTipoIdentificacion(TipoIdentificacionDto tipoidentificacion) {

        TipoIdentificacion tipoIdentificacionEnty = tipoidentificacionDao.findById(tipoidentificacion.getIdTipoIdentificacion()).orElse(null);
        TipoIdentificacionDto objDto = gson.fromJson(gson.toJson(tipoIdentificacionEnty), TipoIdentificacionDto.class);

        return objDto;

    }

    @Override
    @Transactional
    public void deleteTipoIdentificacion(TipoIdentificacion tipoidentificacion) {
        tipoidentificacionDao.delete(tipoidentificacion);
    }

    @Override
    @Transactional
    public TipoIdentificacionDto uptadeTipoIdentificacion(TipoIdentificacion tipoidentificacion) {
                
        TipoIdentificacion tipoIdentificacionEnty = (TipoIdentificacion) tipoidentificacionDao.save(tipoidentificacion);
        TipoIdentificacionDto objDto = gson.fromJson(gson.toJson(tipoIdentificacionEnty), TipoIdentificacionDto.class);

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoIdentificacion> findTipoIdentificacionById(Integer idTipoIdentificacion) {
        return (Optional<TipoIdentificacion>) tipoidentificacionDao.findById(idTipoIdentificacion);
    }

    @Override
    @Transactional
    public void deleteTipoIdentificacion(Integer id) {
        tipoidentificacionDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoIdentificacionDto findById(Integer id) {
        
        TipoIdentificacion tipoIdentificacionEnty = tipoidentificacionDao.findById(id).orElse(null);
        TipoIdentificacionDto objDto = gson.fromJson(gson.toJson(tipoIdentificacionEnty), TipoIdentificacionDto.class);

        return objDto;

        
    }

}
