package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.ug.ec.dao.EstadocivilDao;
import com.ug.ec.domain.EstadoCivil;
import com.ug.ec.dto.EstadoCivilDto;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.ug.ec.servicio.IEstadoCivilService;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoCivilServiceBase implements IEstadoCivilService {

    @Autowired
    private EstadocivilDao estadocivilDao;

    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    @Override
    @Transactional(readOnly = true)
    public List<EstadoCivilDto> findAll() {

        List<EstadoCivilDto> estadoCivilDtos = gson.fromJson(gson.toJson(estadocivilDao.findAll()), ArrayList.class);
        
        return estadoCivilDtos;
    }

    @Override
    @Transactional
    public EstadoCivilDto save(EstadoCivilDto estadocivil) {

        EstadoCivil estadoCivilEnty = mapper.map(estadocivil, EstadoCivil.class);
        estadocivilDao.save(estadoCivilEnty);
        EstadoCivilDto objDto = mapper.map(estadoCivilEnty, EstadoCivilDto.class);

        return objDto;

    }

    @Override
    @Transactional(readOnly = true)
    public EstadoCivilDto findEstadocivil(EstadoCivil estadocivil) {

        EstadoCivil estadoCivilEnty = estadocivilDao.findById(estadocivil.getIdEstadoCivil()).orElse(null);

        EstadoCivilDto objDto = gson.fromJson(gson.toJson(estadoCivilEnty), EstadoCivilDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteEstadocivil(EstadoCivil estadocivil) {
        estadocivilDao.delete(estadocivil);
    }

    @Override
    @Transactional
    public EstadoCivilDto uptadeEstadocivil(EstadoCivil estadocivil) {
        EstadoCivil estadoCivilEnty = (EstadoCivil) estadocivilDao.save(estadocivil);

        EstadoCivilDto objDto = gson.fromJson(gson.toJson(estadoCivilEnty),EstadoCivilDto.class);

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EstadoCivil> findEstadocivilById(Integer idEstadoCivil) {
        return (Optional<EstadoCivil>) estadocivilDao.findById(idEstadoCivil);
    }

    @Override
    @Transactional
    public void deleteEstadocivil(Integer id) {
        estadocivilDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public EstadoCivilDto findById(Integer id) {

        EstadoCivil estadoCivilEnty = estadocivilDao.findById(id).orElse(null);

        EstadoCivilDto objDto = mapper.map(estadoCivilEnty, EstadoCivilDto.class);

        return objDto;
    }
}
