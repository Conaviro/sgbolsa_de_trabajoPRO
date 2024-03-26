package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.ug.ec.dao.NivelDao;
import com.ug.ec.domain.Nivel;
import com.ug.ec.dto.NivelDto;
import com.ug.ec.servicio.INivelService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NivelServiceBase implements INivelService{
    
    @Autowired
    private NivelDao nivelDao;  
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<NivelDto> findAll() {
        
        List<NivelDto> nivelDto = gson.fromJson(gson.toJson(nivelDao.findAll()), ArrayList.class);
        return nivelDto;
    }

    @Override
    @Transactional
    public void save(Nivel nivel) {
         nivelDao.save(nivel);
    }

    @Override
    @Transactional(readOnly = true)
    public NivelDto findNivel(Nivel nivel) {
          
        Nivel nivelEnty = nivelDao.findById(nivel.getIdNivel()).orElse(null); 
        NivelDto objDto = gson.fromJson(gson.toJson(nivelEnty), NivelDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteNivel(Nivel nivel) {
        nivelDao.delete(nivel);
    }

    @Override
    @Transactional
    public NivelDto uptadeNivel(Nivel nivel) {
         
        Nivel nivelEnty = (Nivel)nivelDao.save(nivel);
        NivelDto objDto = gson.fromJson(gson.toJson(nivelEnty), NivelDto.class);
        
        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Nivel> findNivelById(Integer idNivel) {
        return (Optional<Nivel>)nivelDao.findById(idNivel);
    }

    @Override
    @Transactional
    public void deleteNivel(Integer id) {
        nivelDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public NivelDto findById(Integer id) {
         
        
        Nivel idiomaEnty = nivelDao.findById(id).orElse(null);
        NivelDto objDto = gson.fromJson(gson.toJson(idiomaEnty), NivelDto.class);//

        return objDto;
    }
}
