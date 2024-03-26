
package com.ug.ec.servicio.base;
import com.ug.ec.dao.ProvinciaDao;
import com.ug.ec.domain.Provincia;
import com.ug.ec.servicio.IProvinciaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.ug.ec.dto.ProvinciaDto;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;

@Service
public class ProvinciaServiceBase implements IProvinciaService{
     @Autowired
    private ProvinciaDao provinciaDao;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<ProvinciaDto> findAll() {

    List<ProvinciaDto> ProvinciaDtos = gson.fromJson(gson.toJson(provinciaDao.findAll()), ArrayList.class);

    return ProvinciaDtos;
    }

    @Override
    @Transactional
    public void save(Provincia provincia) {
         provinciaDao.save(provincia);
    }

    @Override
    @Transactional(readOnly = true)
    public ProvinciaDto findProvincia(Provincia provincia) {

    Provincia provinciaEnty = provinciaDao.findById(provincia.getIdProvincia()).orElse(null);
    ProvinciaDto objDto = gson.fromJson(gson.toJson(provinciaEnty), ProvinciaDto.class);

    return objDto;
    }

    @Override
    @Transactional
    public void deleteProvincia(Provincia provincia) {
        provinciaDao.delete(provincia);
    }

    @Override
    @Transactional
    public ProvinciaDto uptadeProvincia(Provincia provincia) {

    Provincia provinciaEnty = (Provincia) provinciaDao.save(provincia);
    ProvinciaDto objDto = gson.fromJson(gson.toJson(provinciaEnty), ProvinciaDto.class);
    return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Provincia> findProvinciaById(Integer idProvincia) {
        return (Optional<Provincia>)provinciaDao.findById(idProvincia);
    }

    @Override
    @Transactional
    public void deleteProvincia(Integer id) {
        provinciaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public ProvinciaDto findById(Integer id) {

    Provincia provinciaEnty = provinciaDao.findById(id).orElse(null);
    ProvinciaDto objDto = gson.fromJson(gson.toJson(provinciaEnty), ProvinciaDto.class);//

    return objDto;
    }
    
}
