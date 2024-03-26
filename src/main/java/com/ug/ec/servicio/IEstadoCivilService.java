
package com.ug.ec.servicio;


import com.ug.ec.domain.EstadoCivil;
import com.ug.ec.dto.EstadoCivilDto;
import java.util.List;
import java.util.Optional;


public interface IEstadoCivilService {
    public List<EstadoCivilDto> findAll();
    public EstadoCivilDto save(EstadoCivilDto estadocivil);
    public EstadoCivilDto findEstadocivil(EstadoCivil estadocivil);
    public void deleteEstadocivil(EstadoCivil estadocivil);
    public EstadoCivilDto uptadeEstadocivil(EstadoCivil estadocivil);
    public Optional<EstadoCivil> findEstadocivilById(Integer idEstadocivil);
    public void deleteEstadocivil(Integer id);
    public EstadoCivilDto findById(Integer id);
}
