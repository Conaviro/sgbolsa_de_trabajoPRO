package com.ug.ec.servicio.base;

import com.ug.ec.dao.PaisDao;
import com.ug.ec.domain.Pais;
import com.ug.ec.servicio.IPaisService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.ug.ec.dto.PaisDto;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
@Service
public class PaisServiceBase implements IPaisService{
    
    @Autowired
    private PaisDao paisDao;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    @Override
    @Transactional(readOnly = true)
    public List<PaisDto> findAll() {

    List<PaisDto> PaisDtos = gson.fromJson(gson.toJson(paisDao.findAll()), ArrayList.class);

    return PaisDtos;
    }

    @Override
    @Transactional
    public void save(Pais pais) {
        paisDao.save(pais);
    }

    @Override
    @Transactional(readOnly = true)
    public PaisDto findPais(Pais pais) {

    Pais paisEnty = paisDao.findById(pais.getIdPais()).orElse(null);
    PaisDto objDto = gson.fromJson(gson.toJson(paisEnty), PaisDto.class);

    return objDto;       
    }

    @Override
    @Transactional
    public void deletePais(Pais pais) {
        paisDao.delete(pais);
    }

    @Override
    @Transactional
    public PaisDto uptadePais(Pais pais) {

    Pais paisEnty = (Pais) paisDao.save(pais);
    PaisDto objDto = gson.fromJson(gson.toJson(paisEnty), PaisDto.class);
    return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pais> findPaisById(Integer idPais) {
        return (Optional<Pais>) paisDao.findById(idPais);
    }

    @Override
    @Transactional
    public void deletePais(Integer id) {
        paisDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PaisDto findById(Integer id) {

    Pais paisEnty = paisDao.findById(id).orElse(null);
    PaisDto objDto = gson.fromJson(gson.toJson(paisEnty), PaisDto.class);//

    return objDto;
    }
    
}