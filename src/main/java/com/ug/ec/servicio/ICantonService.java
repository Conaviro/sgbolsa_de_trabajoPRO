
package com.ug.ec.servicio;
import com.ug.ec.domain.Canton;
import java.util.List;
import java.util.Optional;
import com.ug.ec.dto.CantonDto;
public interface ICantonService {
    public List<CantonDto> findAll();

    public void save(Canton canton);

    public CantonDto findCanton(Canton canton);

    public void deleteCanton(Canton canton);

    public CantonDto uptadeCanton(Canton canton);

    public Optional<Canton> findCantonById(Integer idCanton);

    public void deleteCanton(Integer id);

    public CantonDto findById(Integer id);

}
