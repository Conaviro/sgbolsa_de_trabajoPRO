
package com.ug.ec.servicio.base;
import com.google.gson.Gson;
import com.ug.ec.dao.TipoDireccionDao;
import com.ug.ec.domain.TipoDireccion;
import com.ug.ec.dto.TipoDireccionDto;
import com.ug.ec.servicio.ITipoDireccionService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoDireccionServiceBase  implements ITipoDireccionService{
     @Autowired
    private TipoDireccionDao tipodireccionDao;
    
    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoDireccionDto> findAll() {
        
        List<TipoDireccionDto> tipoDireccionDtos = gson.fromJson(gson.toJson(tipodireccionDao.findAll()), ArrayList.class);
        //return (List<TipoDireccion>) tipodireccionDao.findAll();
        return tipoDireccionDtos;
    }

    @Override
    @Transactional
    public void save(TipoDireccion tipodireccion) {
         tipodireccionDao.save(tipodireccion);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoDireccionDto findTipoDireccion(TipoDireccion tipodireccion) {
        
        TipoDireccion tipoDireccionEnty = tipodireccionDao.findById(tipodireccion.getIdTipoDireccion()).orElse(null);
        TipoDireccionDto objDto = gson.fromJson(gson.toJson(tipoDireccionEnty), TipoDireccionDto.class);

        return objDto;
        //return tipodireccionDao.findById(tipodireccion.getIdTipoDireccion()).orElse(null); 
    }

    @Override
    @Transactional
    public void deleteTipoDireccion(TipoDireccion tipodireccion) {
        tipodireccionDao.delete(tipodireccion);
    }

    @Override
    @Transactional
    public TipoDireccionDto uptadeTipoDireccion(TipoDireccion tipodireccion) {
        
        TipoDireccion tipoDireccionEnty = (TipoDireccion) tipodireccionDao.save(tipodireccion);
        TipoDireccionDto objDto = gson.fromJson(gson.toJson(tipoDireccionEnty), TipoDireccionDto.class);

        return objDto;
        //return (TipoDireccion)tipodireccionDao.save(tipodireccion);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoDireccion> findTipoDireccionById(Integer idTipoDireccion) {
        return (Optional<TipoDireccion>)tipodireccionDao.findById(idTipoDireccion);
    }

    @Override
    @Transactional
    public void deleteTipoDireccion(Integer id) {
        tipodireccionDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public TipoDireccionDto findById(Integer id) {
        
        TipoDireccion tipoDireccionEnty = tipodireccionDao.findById(id).orElse(null);
        TipoDireccionDto objDto = gson.fromJson(gson.toJson(tipoDireccionEnty), TipoDireccionDto.class);

        return objDto;
        //return tipodireccionDao.findById(id).orElse(null);
    }
    
}
