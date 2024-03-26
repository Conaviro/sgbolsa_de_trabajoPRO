package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.ug.ec.dao.IdiomaDao;
import com.ug.ec.domain.Idioma;
import com.ug.ec.dto.IdiomaDto;
import com.ug.ec.servicio.IIdiomaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdiomaServiceBase implements IIdiomaService{
    
    @Autowired
    private IdiomaDao idiomaDao;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<IdiomaDto> findAll() {
        
        List<IdiomaDto> idiomaDto = gson.fromJson(gson.toJson(idiomaDao.findAll()), ArrayList.class);
        return idiomaDto;
    }

    @Override
    @Transactional
    public void save(Idioma idioma) {
         idiomaDao.save(idioma);
    }

    @Override
    @Transactional(readOnly = true)
    public IdiomaDto findIdioma(Idioma idioma) {

        Idioma idiomaEnty = idiomaDao.findById(idioma.getIdIdioma()).orElse(null); 
        IdiomaDto objDto = gson.fromJson(gson.toJson(idiomaEnty), IdiomaDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteIdioma(Idioma idioma) {
        idiomaDao.delete(idioma);
    }

    @Override
    @Transactional
    public IdiomaDto uptadeIdioma(Idioma idioma) {         
         
        Idioma idiomaEnty = (Idioma) idiomaDao.save(idioma);
        IdiomaDto objDto = gson.fromJson(gson.toJson(idiomaEnty), IdiomaDto.class);
        
        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Idioma> findIdiomaById(Integer idIdioma) {
        return (Optional<Idioma>)idiomaDao.findById(idIdioma);
    }

    @Override
    @Transactional
    public void deleteIdioma(Integer id) {
        idiomaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public IdiomaDto findById(Integer id) {
 
        Idioma idiomaEnty = idiomaDao.findById(id).orElse(null);
        IdiomaDto objDto = gson.fromJson(gson.toJson(idiomaEnty), IdiomaDto.class);//

        return objDto;
    }
    
}
