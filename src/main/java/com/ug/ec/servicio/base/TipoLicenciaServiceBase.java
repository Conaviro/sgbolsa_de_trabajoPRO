
package com.ug.ec.servicio.base;
import com.google.gson.Gson;
import com.ug.ec.dao.TipoLicenciaDao;
import com.ug.ec.domain.TipoLicencia;
import com.ug.ec.dto.TipoLicenciaDto;
import com.ug.ec.servicio.ITipoLicenciaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoLicenciaServiceBase implements ITipoLicenciaService {
    
    @Autowired
    private TipoLicenciaDao tipolicenciaDao;  
    
    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoLicenciaDto> findAll() {
        
        List<TipoLicenciaDto> tipoLicenciaDtos = gson.fromJson(gson.toJson(tipolicenciaDao.findAll()), ArrayList.class);
/*
        for (TipoLicencia tipolicencia : tipolicenciaDao.findAll()) {
            TipoLicenciaDto objDto = mapper.map(tipolicencia, TipoLicenciaDto.class);
            tipoLicenciaDtos.add(objDto);
        }
*/
        return tipoLicenciaDtos;
    }

    @Override
    @Transactional
    public TipoLicenciaDto save(TipoLicenciaDto tipolicencia) {
         
         
         TipoLicencia tipolicenciaEnty = mapper.map(tipolicencia, TipoLicencia.class);
         tipolicenciaDao.save(tipolicenciaEnty);
         TipoLicenciaDto objDto = mapper.map(tipolicenciaEnty, TipoLicenciaDto.class);

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public TipoLicenciaDto findTipoLicencia(TipoLicenciaDto tipolicencia) {
        
        TipoLicencia tipolicenciaEnty = tipolicenciaDao.findById(tipolicencia.getIdTipoLicencia()).orElse(null);
        TipoLicenciaDto objDto = gson.fromJson(gson.toJson(tipolicenciaEnty), TipoLicenciaDto.class);

        return objDto;
       
    }

    @Override
    @Transactional
    public void deleteTipoLicencia(TipoLicencia tipolicencia) {
        tipolicenciaDao.delete(tipolicencia);
    }

    @Override
    @Transactional
    public TipoLicenciaDto uptadeTipoLicencia(TipoLicencia tipolicencia) {
       
        TipoLicencia tipolicenciaEnty = (TipoLicencia)tipolicenciaDao.save(tipolicencia);
        TipoLicenciaDto objDto = gson.fromJson(gson.toJson(tipolicenciaEnty), TipoLicenciaDto.class);

        return objDto;
    }

    @Override 
    @Transactional(readOnly = true)
    public Optional<TipoLicencia> findTipoLicenciaById(Integer idTipoLicencia) {
        return (Optional<TipoLicencia>)tipolicenciaDao.findById(idTipoLicencia);
    }

    @Override
    @Transactional
    public void deleteTipoLicencia(Integer id) {
        tipolicenciaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public TipoLicenciaDto findById(Integer id) {
        
        TipoLicencia tipolicenciaEnty = tipolicenciaDao.findById(id).orElse(null);
        TipoLicenciaDto objDto = gson.fromJson(gson.toJson(tipolicenciaEnty), TipoLicenciaDto.class);
        return objDto;        
        
    }
    
}
