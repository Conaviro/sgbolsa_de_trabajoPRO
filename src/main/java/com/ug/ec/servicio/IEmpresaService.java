
package com.ug.ec.servicio;

import com.ug.ec.domain.Empresa;
import com.ug.ec.dto.EmpresaDto;
import java.util.List;
import java.util.Optional;

public interface IEmpresaService {
    
    public List<EmpresaDto> findAll();

    public void save(Empresa empresa);

    public EmpresaDto findEmpresa(Empresa empresa);

    public void deleteEmpresa(Empresa empresa);

    public EmpresaDto uptadeEmpresa(Empresa empresa);

    public Optional<Empresa> findEmpresaById(Integer idEmpresa);

    public void deleteEmpresa(Integer id);

    public EmpresaDto findById(Integer id);

    
    
    
    
    
    
    
}
