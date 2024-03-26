package com.ug.ec.servicio;

import com.ug.ec.domain.Direccion;
import com.ug.ec.domain.DireccionPk;
import com.ug.ec.domain.Persona;
import com.ug.ec.dto.DireccionDto;
import java.util.List;
import java.util.Optional;

public interface IDireccionService {
    public List<DireccionDto> findAll();
    public void save(Direccion direccion);
    public DireccionDto findDireccion(Direccion direccion);
    public void deleteDireccion(Direccion direccion);
    public DireccionDto uptadeDireccion(Direccion direccion);
    public Optional<Direccion> findDireccionById(DireccionPk idDireccion);
    public void deleteDireccion(DireccionPk id);
    public DireccionDto findById(DireccionPk id);
    public List<DireccionDto> findByPersonaId(Long idPersona);
    public List<Direccion> findByPersonaId(Persona idPersona);
}