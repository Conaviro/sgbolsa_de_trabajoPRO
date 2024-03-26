
package com.ug.ec.servicio.base;


import com.google.gson.Gson;
import com.ug.ec.dao.EmpresaDao;
import com.ug.ec.domain.Empresa;
import com.ug.ec.dto.EmpresaDto;
import com.ug.ec.servicio.IEmpresaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaServiceBase implements IEmpresaService{
    
  @Autowired
    private EmpresaDao empresaDao;
    
   @Autowired
   ModelMapper mapper;
    
   @Autowired
   Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<EmpresaDto> findAll() {
        
        List<EmpresaDto> empresaDtos = gson.fromJson(gson.toJson(empresaDao.findAll()), ArrayList.class);
        
        return empresaDtos;
        
    }

    @Override
    @Transactional
    public void save(Empresa empresa) {
         empresaDao.save(empresa);
    }

    @Override
    @Transactional(readOnly = true)
    public EmpresaDto findEmpresa(Empresa empresa) {
        Empresa empresaEnty = empresaDao.findById(empresa.getIdEmpresa()).orElse(null);
        EmpresaDto objDto = gson.fromJson(gson.toJson(empresaEnty), EmpresaDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteEmpresa(Empresa empresa) {
        empresaDao.delete(empresa);
    }

    @Override
    @Transactional
    public EmpresaDto uptadeEmpresa(Empresa empresa) {
        Empresa empresaEnty = (Empresa) empresaDao.save(empresa);
       EmpresaDto objDto = gson.fromJson(gson.toJson(empresaEnty), EmpresaDto.class);
        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Empresa> findEmpresaById(Integer idEmpresa) {
        return (Optional<Empresa>)empresaDao.findById(idEmpresa);
    }

    @Override
    @Transactional
    public void deleteEmpresa(Integer id) {
        empresaDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public EmpresaDto findById(Integer id) {
        Empresa empresaEnty = empresaDao.findById(id).orElse(null);
       
       EmpresaDto objDto = gson.fromJson(gson.toJson(empresaEnty), EmpresaDto.class);//

        return objDto;
    }
      
    
}
