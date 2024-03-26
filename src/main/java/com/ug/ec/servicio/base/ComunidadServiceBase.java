package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;

import com.ug.ec.dao.ComunidadDao;
import com.ug.ec.domain.Canton;
import com.ug.ec.domain.Comunidad;
import com.ug.ec.dto.ComunidadDto;
import com.ug.ec.servicio.IComunidadService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.ug.ec.dto.ComunidadDto;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;

@Component
@Service
public class ComunidadServiceBase implements IComunidadService {

    @Autowired
    private ComunidadDao comunidadDao;

    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    @Override
    @Transactional(readOnly = true)
    public List<ComunidadDto> findAll() {
        
              
        List<ComunidadDto> comunidadDtos  = gson.fromJson(gson.toJson(comunidadDao.findAll()), ArrayList.class);
        
        return comunidadDtos;//(List<ComunidadDto>)comunidadDao.findAll();

    }

    @Override
    @Transactional
    public void save(Comunidad comunidad) {
        comunidadDao.save(comunidad);


    }

    @Override
    @Transactional(readOnly = true)
    public ComunidadDto findComunidad(Comunidad comunidad) {

        Comunidad comunidadEnty = comunidadDao.findById(comunidad.getIdComunidad()).orElse(null);
        ComunidadDto objDto = gson.fromJson(gson.toJson(comunidadEnty), ComunidadDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteComunidad(Comunidad comunidad) {
        comunidadDao.delete(comunidad);
    }

    @Override
    @Transactional
    public ComunidadDto uptadeComunidad(Comunidad comunidad) {

    Comunidad comunidadEnty = (Comunidad) comunidadDao.save(comunidad);
    ComunidadDto objDto = gson.fromJson(gson.toJson(comunidadEnty), ComunidadDto.class);
    return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comunidad> findComunidadById(Integer idComunidad) {

        return (Optional<Comunidad>) comunidadDao.findById(idComunidad);
    }

    @Override
    @Transactional
    public void deleteComunidad(Integer id) {
        comunidadDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ComunidadDto findById(Integer id) {

    Comunidad comunidadEnty = comunidadDao.findById(id).orElse(null);
    ComunidadDto objDto = gson.fromJson(gson.toJson(comunidadEnty), ComunidadDto.class);//

    return objDto;      
    }

   
}
