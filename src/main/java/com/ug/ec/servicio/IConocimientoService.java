
package com.ug.ec.servicio;

import com.ug.ec.domain.Conocimiento;
import java.util.List;
import java.util.Optional;
import com.ug.ec.dto.ConocimientoDto;
public interface IConocimientoService {
        public List<ConocimientoDto> findAll();

    public void save(Conocimiento conocimiento);

    public ConocimientoDto findConocimiento(Conocimiento conocimiento);

    public void deleteConocimiento(Conocimiento conocimiento);

    public ConocimientoDto uptadeConocimiento(Conocimiento conocimiento);

    public Optional<Conocimiento> findConocimientoById(Integer idConocimiento);

    public void deleteConocimiento(Integer id);

    public ConocimientoDto findById(Integer id);
}
