
package com.ug.ec.servicio.base;
import com.ug.ec.dao.ReferenciaDao;
import com.ug.ec.domain.Referencia;
import com.ug.ec.servicio.IReferenciaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.ug.ec.dto.ReferenciaDto;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;

@Service
public class ReferenciaServiceBase implements IReferenciaService{
   @Autowired
    private ReferenciaDao referenciaDao;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<ReferenciaDto> findAll() {

    List<ReferenciaDto> ReferenciaDtos = gson.fromJson(gson.toJson(referenciaDao.findAll()), ArrayList.class);

    return ReferenciaDtos;
    }

    @Override
    @Transactional
    public void save(Referencia referencia) {
         referenciaDao.save(referencia);
    }

    @Override
    @Transactional(readOnly = true)
    public ReferenciaDto findReferencia(Referencia referencia) {

    Referencia referenciaEnty = referenciaDao.findById(referencia.getIdReferencia()).orElse(null);
    ReferenciaDto objDto = gson.fromJson(gson.toJson(referenciaEnty), ReferenciaDto.class);

    return objDto;
     }

    @Override
    @Transactional
    public void deleteReferencia(Referencia referencia) {
        referenciaDao.delete(referencia);
    }

    @Override
    @Transactional
    public ReferenciaDto uptadeReferencia(Referencia referencia) {

    Referencia referenciaEnty = (Referencia) referenciaDao.save(referencia);
    ReferenciaDto objDto = gson.fromJson(gson.toJson(referenciaEnty), ReferenciaDto.class);
    return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Referencia> findReferenciaById(Integer idReferencia) {
        return (Optional<Referencia>)referenciaDao.findById(idReferencia);
    }

    @Override
    @Transactional
    public void deleteReferencia(Integer id) {
        referenciaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public ReferenciaDto findById(Integer id) {

    Referencia referenciaEnty = referenciaDao.findById(id).orElse(null);
    ReferenciaDto objDto = gson.fromJson(gson.toJson(referenciaEnty), ReferenciaDto.class);//

    return objDto;
    }
      
}
