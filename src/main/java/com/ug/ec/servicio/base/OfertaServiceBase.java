
package com.ug.ec.servicio.base;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ug.ec.dao.OfertaDao;
//import com.ug.ec.dao.OfertaDao;
import com.ug.ec.domain.Oferta;
import com.ug.ec.dto.OfertaDto;
import com.ug.ec.servicio.IOfertaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OfertaServiceBase implements  IOfertaService{
    
    @Autowired
    private OfertaDao ofertaDao;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<OfertaDto> findAll() {
         gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        List<OfertaDto> ofertaDto = gson.fromJson(gson.toJson(ofertaDao.findAll()), ArrayList.class);
        return ofertaDto;
    }

    @Override
    @Transactional
    public void save(Oferta oferta) {
         ofertaDao.save(oferta);
    }

    @Override
    @Transactional(readOnly = true)
    public OfertaDto findOferta(Oferta oferta) {
         
        Oferta ofertaEnty = ofertaDao.findById(oferta.getIdOferta()).orElse(null); 
        OfertaDto objDto = gson.fromJson(gson.toJson(ofertaEnty), OfertaDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteOferta(Oferta oferta) {
        ofertaDao.delete(oferta);
    }

    @Override
    @Transactional
    public OfertaDto uptadeOferta(Oferta oferta) {
         
        
        Oferta ofertaEnty = (Oferta)ofertaDao.save(oferta);
        OfertaDto objDto = gson.fromJson(gson.toJson(ofertaEnty), OfertaDto.class);
        
        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Oferta> findOfertaById(Long idOferta) {
        return (Optional<Oferta>)ofertaDao.findById(idOferta);
    }

    @Override
    @Transactional
    public void deleteOferta(Long id) {
        ofertaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public OfertaDto findById(Long id) {
        
        Oferta ofertaEnty = ofertaDao.findById(id).orElse(null);
        OfertaDto objDto = gson.fromJson(gson.toJson(ofertaEnty), OfertaDto.class);//

        return objDto;
    }


//    @Override
//    public List<Oferta> buscarDestacadas() {
//        return ofertaDao.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
//    }
//
//    @Override
//    public List<Oferta> buscarByExample(Example<Oferta> example) {
//        return ofertaDao.findAll(example);
//    }

    @Override
    public List<OfertaDto> buscarDestacadas() {        
         gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        List<OfertaDto> ofertaDto = gson.fromJson(gson.toJson(ofertaDao.findByDestacadoAndEstatus(1, "Aprobada")), ArrayList.class);
        return ofertaDto;
    }

    @Override
    public List<OfertaDto> buscarByExample(Example<Oferta> example) {
         gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        List<OfertaDto> ofertaDto = gson.fromJson(gson.toJson(ofertaDao.findAll(example) ), ArrayList.class);
        return ofertaDto;
    }

   
    
}
