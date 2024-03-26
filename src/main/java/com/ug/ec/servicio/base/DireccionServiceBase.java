package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ug.ec.dao.DireccionDao;
import com.ug.ec.domain.Direccion;
import com.ug.ec.domain.DireccionPk;
import com.ug.ec.domain.Persona;
import com.ug.ec.dto.DireccionDto;
import com.ug.ec.servicio.IDireccionService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DireccionServiceBase implements IDireccionService{
    
    @Autowired
    private DireccionDao direccionDao;
    
    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    @Override
    @Transactional(readOnly = true)
    public List<DireccionDto> findAll() {
        List<DireccionDto> direccionDtos = gson.fromJson(gson.toJson(direccionDao.findAll()), ArrayList.class);
        
        return direccionDtos;
    }

    @Override
    @Transactional
    public void save(Direccion direccion) {
        direccionDao.save(direccion);
    }

    @Override
    @Transactional(readOnly = true)
    public DireccionDto findDireccion(Direccion direccion) {
        
        Direccion direccionEnty = direccionDao.findById(direccion.getLlave()).orElse(null);

        DireccionDto objDto = gson.fromJson(gson.toJson(direccionEnty), DireccionDto.class);

        return objDto;
        
    }

    @Override
    @Transactional
    public void deleteDireccion(Direccion direccion) {
        direccionDao.delete(direccion);
    }

    @Override
    @Transactional
    public DireccionDto uptadeDireccion(Direccion direccion) {
        Direccion direccionEnty = (Direccion) direccionDao.save(direccion);

        DireccionDto objDto = gson.fromJson(gson.toJson(direccionEnty),DireccionDto.class);

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Direccion> findDireccionById(DireccionPk idDireccion) {
        return (Optional<Direccion>) direccionDao.findById(idDireccion);
    }

    @Override
    @Transactional
    public void deleteDireccion(DireccionPk id) {
        direccionDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public DireccionDto findById(DireccionPk id) {
        Direccion direccionEnty = direccionDao.findById(id).orElse(null);

        DireccionDto objDto = mapper.map(direccionEnty, DireccionDto.class);

        return objDto;
    }

    @Override
    public List<DireccionDto> findByPersonaId(Long idPersona) {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
         List<Direccion> direccionEnty = direccionDao.findByPersona(idPersona);
        List<DireccionDto> direccionDtoEnty =gson.fromJson(gson.toJson(direccionEnty),ArrayList.class);
                //.orElse(null); 
        return direccionDtoEnty;
    }

    @Override
    public List<Direccion> findByPersonaId(Persona idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}