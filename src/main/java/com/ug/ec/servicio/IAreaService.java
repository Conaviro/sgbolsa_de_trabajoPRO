
package com.ug.ec.servicio;
import com.ug.ec.domain.Area;
import java.util.List;
import java.util.Optional;
import com.ug.ec.dto.AreaDto;

public interface IAreaService {
    public List<AreaDto> findAll();

    public void save(Area area);

    public AreaDto findArea(Area area);

    public void deleteArea(Area area);

    public AreaDto uptadeArea(Area area);

    public Optional<Area> findAreaById(Integer idArea);

    public void deleteArea(Integer id);

    public AreaDto findById(Integer id);
}
