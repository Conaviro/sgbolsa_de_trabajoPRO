package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.ug.ec.dao.OficioDao;
import com.ug.ec.domain.Oficio;
import com.ug.ec.dto.OficioDto;
import com.ug.ec.servicio.IOficioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OficioServiceBase implements IOficioService {

    @Autowired
    private OficioDao oficioDao;
    
    @Autowired
    Gson gson;
    

    @Override
    @Transactional(readOnly = true)
    public List<OficioDto> findAll() {
        
       List<OficioDto> oficioDto = gson.fromJson(gson.toJson(oficioDao.findAll()), ArrayList.class);
       return oficioDto;
    }

    @Override
    @Transactional
    public void save(Oficio oficio) {
        oficioDao.save(oficio);
    }

    @Override
    @Transactional(readOnly = true)
    public OficioDto findOficio(Oficio oficio) { 
        
        Oficio oficioEnty = oficioDao.findById(oficio.getIdOficio()).orElse(null);
        OficioDto objDto = gson.fromJson(gson.toJson(oficioEnty), OficioDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteOficio(Oficio oficio) {
        oficioDao.delete(oficio);
    }

    @Override
    @Transactional
    public OficioDto uptadeOficio(Oficio oficio) {
        
        Oficio oficioEnty = (Oficio) oficioDao.save(oficio);
        OficioDto objDto = gson.fromJson(gson.toJson(oficioEnty), OficioDto.class);
        
        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Oficio> findOficioById(Integer idOficio) {
        return (Optional<Oficio>) oficioDao.findById(idOficio);
    }

    @Override
    @Transactional
    public void deleteOficio(Integer id) {
        oficioDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public OficioDto findById(Integer id) {
         
        Oficio oficioEnty = oficioDao.findById(id).orElse(null);
        
        
        //hojaDb.get(0).setOficio(oficioService.findById(1));
        
        OficioDto objDto = gson.fromJson(gson.toJson(oficioEnty), OficioDto.class);//

        return objDto;
    }

    @Override
    public Oficio findByIdOf(Integer id) {
        return oficioDao.getById(id);
    }

}
