
package com.ug.ec.servicio.base;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ug.ec.dao.HojaVidaDao;
import com.ug.ec.dao.OficioHojaDao;
import com.ug.ec.domain.HojaVida;
import com.ug.ec.domain.OficioHoja;
import com.ug.ec.domain.Persona;
import com.ug.ec.dto.HojaVidaDto;
import com.ug.ec.dto.OficioDto;
import com.ug.ec.dto.OficioHojaDto;
import com.ug.ec.servicio.IHojaVidaService;
import com.ug.ec.servicio.IOficioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HojaVidaServiceBase implements IHojaVidaService {
    @Autowired
    private HojaVidaDao hojavidaDao;
    
    @Autowired
    private OficioHojaDao oficioHojaDao;
    
    @Autowired
    private IOficioService oficioService;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<HojaVidaDto> findAll() {
        
        List<HojaVidaDto> hojaVidaDto = gson.fromJson(gson.toJson(hojavidaDao.findAll()), ArrayList.class);
        return hojaVidaDto;
    }

    @Override
    @Transactional
    public void save(HojaVida hojavida) {
         hojavidaDao.save(hojavida);
    }

    @Override
    @Transactional(readOnly = true)
    public HojaVidaDto findHojaVida(HojaVida hojavida) {
         
        HojaVida hojaVidaEnty =  hojavidaDao.findById(hojavida.getIdHojaVida()).orElse(null); 
        HojaVidaDto objDto = gson.fromJson(gson.toJson(hojaVidaEnty), HojaVidaDto.class);
        
        return objDto;
    }

    @Override
    @Transactional
    public void deleteHojaVida(HojaVida hojavida) {
        hojavidaDao.delete(hojavida);
    }

    @Override
    @Transactional
    public HojaVidaDto uptadeHojaVida(HojaVida hojavida) {
        
        HojaVida hoajaVidaEnty = (HojaVida)hojavidaDao.save(hojavida);
        HojaVidaDto objDto = gson.fromJson(gson.toJson(hoajaVidaEnty), HojaVidaDto.class);
        
        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<HojaVida> findHojaVidaById(Long idHojaVida) {
        return (Optional<HojaVida>)hojavidaDao.findById(idHojaVida);
    }

    @Override
    @Transactional
    public void deleteHojaVida(Long id) {
        hojavidaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public HojaVidaDto findById(Long id) {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        HojaVida idiomaEnty =  hojavidaDao.findById(id).orElse(null);
        HojaVidaDto objDto = gson.fromJson(gson.toJson(idiomaEnty), HojaVidaDto.class);//

        return objDto;
    }

    @Override
    public Persona findHojaVidaPersona(Long id) {
        return hojavidaDao.findByPersona(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HojaVidaDto findHojaVidaPersonaId(Long id) {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        HojaVida idiomaEnty =  hojavidaDao.findByPersonaId(id);
        HojaVidaDto objDto = gson.fromJson(gson.toJson(idiomaEnty), HojaVidaDto.class);//

        return objDto;
    }

    @Override
    public void saveOficioHoja(OficioHoja oficioHoja) {
        oficioHojaDao.save(oficioHoja);
    }

    @Override
    public void deleteOficioHoja(OficioHoja oficioHoja) {
        oficioHojaDao.delete(oficioHoja);
    }

    @Override
    public List<OficioHoja> findOficioHojaAll() {
        List<OficioHoja> oficioHoja = oficioHojaDao.findAll();//gson.fromJson(gson.toJson(oficioHojaDao.findAll()), ArrayList.class);
        return oficioHoja;
    }

    private OficioDto getOficio(Integer id)
    {
        return oficioService.findById(id);
    }
    
    @Override
    public List<OficioHojaDto> findOficioHojaPersonaId(Long id) {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        List<OficioHoja> enty =  oficioHojaDao.findByOfiHojaPersona(id);           

        List<OficioHojaDto> objDto = gson.fromJson(gson.toJson(enty), ArrayList.class);//
        
        
        return objDto;
    }

    
    
}
