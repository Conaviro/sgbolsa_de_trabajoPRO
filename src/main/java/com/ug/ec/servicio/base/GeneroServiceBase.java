package com.ug.ec.servicio.base;

import com.ug.ec.dao.GeneroDao;
import com.ug.ec.domain.Genero;
import com.ug.ec.dto.GeneroDto;
import com.ug.ec.servicio.IGeneroService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneroServiceBase implements IGeneroService{

    @Autowired
    private GeneroDao generoDao;
    
    @Autowired
    ModelMapper mapper;
    
    @Override
    @Transactional(readOnly = true)
    public List<GeneroDto> findAll() {
        
        List<GeneroDto> generoDtos = new ArrayList<>();

        for (Genero genero : generoDao.findAll()) {
            GeneroDto objDto = mapper.map(genero, GeneroDto.class);
            generoDtos.add(objDto);
        }

        return generoDtos;
    }

    @Override
    @Transactional
    public GeneroDto save(GeneroDto genero) {
        
        Genero generoEnty = mapper.map(genero, Genero.class);
         generoDao.save(generoEnty);
         GeneroDto objDto = mapper.map(generoEnty, GeneroDto.class);

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public GeneroDto findGenero(GeneroDto genero) {
        
        Genero generoEnty = generoDao.findById(genero.getIdGenero()).orElse(null);
        GeneroDto objDto = mapper.map(generoEnty, GeneroDto.class);
         return objDto; 
    }

    @Override
    @Transactional
    public void deleteGenero(Genero genero) {
        generoDao.delete(genero);
    }

    @Override
    @Transactional
    public GeneroDto uptadeGenero(Genero genero) {
         Genero generoEnty =(Genero)generoDao.save(genero);
         GeneroDto objDto = mapper.map(generoEnty, GeneroDto.class);
        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Genero> findGeneroById(Integer idGenero) {
        return (Optional<Genero>)generoDao.findById(idGenero);
    }

    @Override
    @Transactional
    public void deleteGenero(Integer id) {
        generoDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public GeneroDto findById(Integer id) {
        Genero generoEnty = generoDao.findById(id).orElse(null);
        GeneroDto objDto = mapper.map(generoEnty, GeneroDto.class);
        return objDto;
    }
    
}