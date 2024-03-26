
package com.ug.ec.servicio.base;
import com.ug.ec.dao.ConocimientoDao;
import com.ug.ec.domain.Conocimiento;
import com.ug.ec.servicio.IConocimientoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.ug.ec.dto.ConocimientoDto;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;

@Service
public class ConocimientoServiceBase implements IConocimientoService{
    
    @Autowired
    private ConocimientoDao conocimientoDao;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<ConocimientoDto> findAll() {

    List<ConocimientoDto> ConocimientoDtos = gson.fromJson(gson.toJson(conocimientoDao.findAll()), ArrayList.class);

    return ConocimientoDtos;
    }

    @Override
    @Transactional
    public void save(Conocimiento conocimiento) {
         conocimientoDao.save(conocimiento);
    }

    @Override
    @Transactional(readOnly = true)
     public ConocimientoDto findConocimiento(Conocimiento conocimiento) {

    Conocimiento conocimientoEnty = conocimientoDao.findById(conocimiento.getIdConocimiento()).orElse(null);
    ConocimientoDto objDto = gson.fromJson(gson.toJson(conocimientoEnty), ConocimientoDto.class);

    return objDto;
     }

    @Override
    @Transactional
    public void deleteConocimiento(Conocimiento conocimiento) {
        conocimientoDao.delete(conocimiento);
    }

    @Override
    @Transactional
    public ConocimientoDto uptadeConocimiento(Conocimiento conocimiento) {

    Conocimiento conocimientoEnty = (Conocimiento) conocimientoDao.save(conocimiento);
    ConocimientoDto objDto = gson.fromJson(gson.toJson(conocimientoEnty), ConocimientoDto.class);
    return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Conocimiento> findConocimientoById(Integer idConocimiento) {
        return (Optional<Conocimiento>)conocimientoDao.findById(idConocimiento);
    }

    @Override
    @Transactional
    public void deleteConocimiento(Integer id) {
        conocimientoDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public ConocimientoDto findById(Integer id) {

    Conocimiento conocimientoEnty = conocimientoDao.findById(id).orElse(null);
    ConocimientoDto objDto = gson.fromJson(gson.toJson(conocimientoEnty), ConocimientoDto.class);//

    return objDto;
    }
    
}
