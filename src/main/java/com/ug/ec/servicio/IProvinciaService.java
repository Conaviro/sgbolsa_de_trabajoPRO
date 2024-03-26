
package com.ug.ec.servicio;

import com.ug.ec.domain.Provincia;
import java.util.List;
import java.util.Optional;
import com.ug.ec.dto.ProvinciaDto;

public interface IProvinciaService {
     public List<ProvinciaDto> findAll();

    public void save(Provincia provincia);

    public ProvinciaDto findProvincia(Provincia provincia);

    public void deleteProvincia(Provincia provincia);

    public ProvinciaDto uptadeProvincia(Provincia provincia);

    public Optional<Provincia> findProvinciaById(Integer idProvincia);

    public void deleteProvincia(Integer id);

    public ProvinciaDto findById(Integer id);
}
