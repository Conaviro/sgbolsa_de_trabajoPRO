
package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.ug.ec.dao.SubAreaDao;
import com.ug.ec.domain.SubArea;
import com.ug.ec.dto.SubAreaDto;
import com.ug.ec.servicio.ISubAreaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class SubAreaServiceBase implements ISubAreaService{
    
    @Autowired
    private SubAreaDao subareaDao;
    
    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<SubAreaDto> findAll() {
        List<SubAreaDto> subAreaDtos = gson.fromJson(gson.toJson(subareaDao.findAll()), ArrayList.class);
        return subAreaDtos;
    }

    @Override
    @Transactional
    public void save(SubArea subarea) {
         subareaDao.save(subarea);
    }

    @Override
    @Transactional(readOnly = true)
    public SubAreaDto findSubArea(SubArea subarea) {
        
        SubArea subAreaEnty = subareaDao.findById(subarea.getIdSubArea()).orElse(null);
        SubAreaDto objDto = gson.fromJson(gson.toJson(subAreaEnty), SubAreaDto.class);
        
        return objDto;
        //return subareaDao.findById(subarea.getIdSubArea()).orElse(null); 
    }

    @Override
    @Transactional
    public void deleteSubArea(SubArea subarea) {
        subareaDao.delete(subarea);
    }

    @Override
    @Transactional
    public SubAreaDto uptadeSubArea(SubArea subarea) {
        
        SubArea subAreaEnty = (SubArea) subareaDao.save(subarea);
        SubAreaDto objDto = gson.fromJson(gson.toJson(subAreaEnty), SubAreaDto.class);//

        return objDto;
        //return (SubArea)subareaDao.save(subarea);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SubArea> findSubAreaById(Integer idSubArea) {
        return (Optional<SubArea>)subareaDao.findById(idSubArea);
    }

    @Override
    @Transactional
    public void deleteSubArea(Integer id) {
        subareaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public SubAreaDto findById(Integer id) {
        
        SubArea subAreaEnty = subareaDao.findById(id).orElse(null);
        SubAreaDto objDto = gson.fromJson(gson.toJson(subAreaEnty), SubAreaDto.class);//

        return objDto;
        //return subareaDao.findById(id).orElse(null);
    }
    
}
