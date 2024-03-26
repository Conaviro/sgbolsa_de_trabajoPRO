
package com.ug.ec.servicio.base;
import com.google.gson.Gson;
import com.ug.ec.dao.EstudioDao;
import com.ug.ec.domain.Estudio;
import com.ug.ec.dto.EstudioDto;
import com.ug.ec.servicio.IEstudioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EstudioServiceBase implements IEstudioService{
  
    @Autowired
    private EstudioDao estudioDao;

    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    
    @Override
    @Transactional(readOnly = true)
    public List<EstudioDto> findAll() {
        List<EstudioDto> estudioDtos = gson.fromJson(gson.toJson(estudioDao.findAll()), ArrayList.class);
        return estudioDtos;
    }

    @Override
    @Transactional
    public void save(Estudio estudio) {
         //Estudio estudioEnty = mapper.map(estudio, Estudio.class);

         estudioDao.save(estudio);
        //Estudio objDto = mapper.map(estudioEnty, EstudioDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public EstudioDto findEstudio(Estudio estudio) {
         Estudio estudioEnty = estudioDao.findById(estudio.getIdEstudio()).orElse(null);
         EstudioDto objDto = gson.fromJson(gson.toJson(estudioEnty), EstudioDto.class);//mapper.map(personaEnty, PersonaDto.class);
         return objDto; 
    }

    @Override
    @Transactional
    public void deleteEstudio(Estudio estudio) {
        estudioDao.delete(estudio);
    }

    @Override
    @Transactional
    public EstudioDto uptadeEstudio(Estudio estudio) {
        Estudio estudioEnty = (Estudio) estudioDao.save(estudio);
       // EstudioDto objDto = mapper.map(estudioEnty, estudioDto.class);
       EstudioDto objDto = gson.fromJson(gson.toJson(estudioEnty), EstudioDto.class);//

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Estudio> findEstudioById(Integer idEstudio) {
        return (Optional<Estudio>)estudioDao.findById(idEstudio);
    }

    @Override
    @Transactional
    public void deleteEstudio(Integer id) {
        estudioDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public EstudioDto findById(Integer id) {
       Estudio estudioEnty = estudioDao.findById(id).orElse(null);
       // EstudioDto objDto = mapper.map(estudioEnty, estudioDto.class);
       EstudioDto objDto = gson.fromJson(gson.toJson(estudioEnty), EstudioDto.class);//

        return objDto;
    }  
}
