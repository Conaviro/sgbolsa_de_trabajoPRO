
package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.ug.ec.dao.ExperienciaDao;
import com.ug.ec.domain.Experiencia;
import com.ug.ec.dto.ExperienciaDto;
import com.ug.ec.servicio.IExperienciaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExperienciaServiceBase implements IExperienciaService{

    @Autowired
    private ExperienciaDao experienciaDao;
    
    @Autowired
    private ExperienciaDao ExperienciaDao;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<ExperienciaDto> findAll() {
        List<ExperienciaDto> experienciaDtos =null;
        try {
              experienciaDtos = gson.fromJson(gson.toJson( experienciaDao.findAll()),ArrayList.class);
        } catch (Exception e) {
        }
       
       //new ArrayList<>();
//
//        for (Experiencia experiencia : experienciaDao.findAll()) {
//            ExperienciaDto objDto = mapper.map(experiencia, ExperienciaDto.class);
//            experienciaDtos.add(objDto);
//        }
        
        return experienciaDtos;
    }

    @Override
    @Transactional
    public void save(Experiencia experiencia) {
         //Experiencia experienciaEnty = mapper.map(experiencia, Experiencia.class);
         experienciaDao.save(experiencia);
        //Experiencia objDto = mapper.map(experienciaEnty, ExperienciaDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public ExperienciaDto findExperiencia(Experiencia experiencia) {

        Experiencia experienciaEnty = experienciaDao.findById(experiencia.getIdExperiencia()).orElse(null);
        ExperienciaDto objDto = gson.fromJson(gson.toJson(experienciaEnty), ExperienciaDto.class);//mapper.map(experienciaEnty, ExperienciaDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteExperiencia(Experiencia experiencia) {
        experienciaDao.delete(experiencia);
    }

    @Override
    @Transactional
    public ExperienciaDto uptadeExperiencia(Experiencia experiencia) {
        Experiencia experienciaEnty = (Experiencia) experienciaDao.save(experiencia);
       // PersonaDto objDto = mapper.map(personaEnty, PersonaDto.class);
       ExperienciaDto objDto = gson.fromJson(gson.toJson(experienciaEnty), ExperienciaDto.class);//

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Experiencia> findExperienciaById(Integer idExperiencia) {
        return (Optional<Experiencia>)experienciaDao.findById(idExperiencia);
    }

    @Override
    @Transactional
    public void deleteExperiencia(Integer id) {
        experienciaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public ExperienciaDto findById(Integer id) {
        Experiencia experienciaEnty = experienciaDao.findById(id).orElse(null);
       // ExperienciaDto objDto = mapper.map(experienciaEnty, ExperienciaDto.class);
       ExperienciaDto objDto = gson.fromJson(gson.toJson(experienciaEnty), ExperienciaDto.class);//

        return objDto;
    }
    
}
