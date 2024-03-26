package com.ug.ec.servicio.base;

import com.ug.ec.dao.ParroquiaDao;
import com.ug.ec.domain.Parroquia;
import com.ug.ec.servicio.IParroquiaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.ug.ec.dto.ParroquiaDto;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;

@Service
public class ParroquiaServiceBase implements IParroquiaService{
    @Autowired
    private ParroquiaDao parroquiaDao;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    @Override
    @Transactional(readOnly = true)
    public List<ParroquiaDto> findAll() {

    List<ParroquiaDto> ParroquiaDtos = gson.fromJson(gson.toJson(parroquiaDao.findAll()), ArrayList.class);

    return ParroquiaDtos;
    }

    @Override
    @Transactional
    public void save(Parroquia parroquia) {
        parroquiaDao.save(parroquia);
    }

    @Override
    @Transactional(readOnly = true)
    public ParroquiaDto findParroquia(Parroquia parroquia) {

    Parroquia parroquiaEnty = parroquiaDao.findById(parroquia.getIdParroquia()).orElse(null);
    ParroquiaDto objDto = gson.fromJson(gson.toJson(parroquiaEnty), ParroquiaDto.class);

    return objDto;
    }

    @Override
    @Transactional
    public void deleteParroquia(Parroquia parroquia) {
        parroquiaDao.delete(parroquia);
    }

    @Override
    @Transactional
    public ParroquiaDto uptadeParroquia(Parroquia parroquia) {

    Parroquia parroquiaEnty = (Parroquia) parroquiaDao.save(parroquia);
    ParroquiaDto objDto = gson.fromJson(gson.toJson(parroquiaEnty), ParroquiaDto.class);
    return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Parroquia> findParroquiaById(Integer idParroquia) {
        return (Optional<Parroquia>) parroquiaDao.findById(idParroquia);
    }

    @Override
    @Transactional
    public void deleteParroquia(Integer id) {
        parroquiaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ParroquiaDto findById(Integer id) {

    Parroquia parroquiaEnty = parroquiaDao.findById(id).orElse(null);
    ParroquiaDto objDto = gson.fromJson(gson.toJson(parroquiaEnty), ParroquiaDto.class);//

    return objDto;
    }
}