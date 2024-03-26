
package com.ug.ec.servicio.base;
import com.ug.ec.dao.CantonDao;
import com.ug.ec.domain.Canton;
import com.ug.ec.servicio.ICantonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.ug.ec.dto.CantonDto;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;

@Service
public class CantonServiceBase implements ICantonService {
    @Autowired
    private CantonDao cantonDao;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<CantonDto> findAll() {

    List<CantonDto> CantonDtos = gson.fromJson(gson.toJson(cantonDao.findAll()), ArrayList.class);

        return CantonDtos;
    }

    @Override
    @Transactional
    public void save(Canton canton) {
         cantonDao.save(canton);
    }

    @Override
    @Transactional(readOnly = true)
    public CantonDto findCanton(Canton canton) {

    Canton cantonEnty = cantonDao.findById(canton.getIdCanton()).orElse(null);
    CantonDto objDto = gson.fromJson(gson.toJson(cantonEnty), CantonDto.class);

    return objDto;
     }

    @Override
    @Transactional
    public void deleteCanton(Canton canton) {
        cantonDao.delete(canton);
    }

    @Override
    @Transactional
    public CantonDto uptadeCanton(Canton canton) {

    Canton cantonEnty = (Canton) cantonDao.save(canton);
    CantonDto objDto = gson.fromJson(gson.toJson(cantonEnty), CantonDto.class);
    return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Canton> findCantonById(Integer idCanton) {
        return (Optional<Canton>)cantonDao.findById(idCanton);
    }

    @Override
    @Transactional
    public void deleteCanton(Integer id) {
        cantonDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public CantonDto findById(Integer id) {

       Canton cantonEnty = cantonDao.findById(id).orElse(null);
       CantonDto objDto = gson.fromJson(gson.toJson(cantonEnty), CantonDto.class);//

        return objDto;
    }
    
}
