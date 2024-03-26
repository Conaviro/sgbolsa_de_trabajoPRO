
package com.ug.ec.servicio;
import com.ug.ec.domain.SubArea;
import com.ug.ec.dto.SubAreaDto;
import java.util.List;
import java.util.Optional;

public interface ISubAreaService {
        public List<SubAreaDto> findAll();

    public void save(SubArea subarea);

    public SubAreaDto findSubArea(SubArea subarea);

    public void deleteSubArea(SubArea subarea);

    public SubAreaDto uptadeSubArea(SubArea subarea);

    public Optional<SubArea> findSubAreaById(Integer idSubArea);

    public void deleteSubArea(Integer id);

    public SubAreaDto findById(Integer id);

}
