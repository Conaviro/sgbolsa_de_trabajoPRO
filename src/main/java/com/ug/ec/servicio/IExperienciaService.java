
package com.ug.ec.servicio;

import com.ug.ec.domain.Experiencia;
import com.ug.ec.dto.ExperienciaDto;
import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
       public List<ExperienciaDto> findAll();

    public void save(Experiencia experiencia);

    public ExperienciaDto findExperiencia(Experiencia experiencia);

    public void deleteExperiencia(Experiencia experiencia);

    public ExperienciaDto uptadeExperiencia(Experiencia experiencia);

    public Optional<Experiencia> findExperienciaById(Integer idExperiencia);

    public void deleteExperiencia(Integer id);

    public ExperienciaDto findById(Integer id);
 
}
