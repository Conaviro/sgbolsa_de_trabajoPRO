
package com.ug.ec.servicio;

import com.ug.ec.domain.Estudio;
import com.ug.ec.dto.EstudioDto;
import java.util.List;
import java.util.Optional;

public interface IEstudioService {
    public List<EstudioDto> findAll();
    public void save(Estudio estudio);
    public EstudioDto findEstudio(Estudio estudio);
    public void deleteEstudio(Estudio estudio);
    public EstudioDto uptadeEstudio(Estudio estudio);
    public Optional<Estudio> findEstudioById(Integer idEstudio);
    public void deleteEstudio(Integer id);
    public EstudioDto findById(Integer id);
}
