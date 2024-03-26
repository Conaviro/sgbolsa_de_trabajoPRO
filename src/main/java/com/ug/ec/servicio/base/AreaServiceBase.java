
package com.ug.ec.servicio.base;
import com.ug.ec.dao.AreaDao;
import com.ug.ec.domain.Area;
import com.ug.ec.servicio.IAreaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.ug.ec.dto.AreaDto;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;

@Service
public class AreaServiceBase implements IAreaService{
    
   @Autowired
   private AreaDao areaDao;
    
   @Autowired
   ModelMapper mapper;

   @Autowired
   Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<AreaDto> findAll() {

    List<AreaDto> AreaDtos = gson.fromJson(gson.toJson(areaDao.findAll()), ArrayList.class);

        return AreaDtos;
    }

    @Override
    @Transactional
    public void save(Area area) {
         areaDao.save(area);
    }

    @Override
    @Transactional(readOnly = true)
    public AreaDto findArea(Area area) {

        Area areaEnty = areaDao.findById(area.getIdArea()).orElse(null);
        AreaDto objDto = gson.fromJson(gson.toJson(areaEnty), AreaDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteArea(Area area) {
        areaDao.delete(area);
    }

    @Override
    @Transactional
       public AreaDto uptadeArea(Area area) {

       Area areaEnty = (Area) areaDao.save(area);
       AreaDto objDto = gson.fromJson(gson.toJson(areaEnty), AreaDto.class);
        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Area> findAreaById(Integer idArea) {
        return (Optional<Area>)areaDao.findById(idArea);
    }

    @Override
    @Transactional
    public void deleteArea(Integer id) {
        areaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public AreaDto findById(Integer id) {

       Area areaEnty = areaDao.findById(id).orElse(null);
       AreaDto objDto = gson.fromJson(gson.toJson(areaEnty), AreaDto.class);//

        return objDto;
    }
    
}


