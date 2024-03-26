package com.ug.ec.servicio;

import com.ug.ec.domain.Pais;
import java.util.List;
import java.util.Optional;
import com.ug.ec.dto.PaisDto;

public interface IPaisService {
    public List<PaisDto> findAll();
    public void save(Pais pais);
    public PaisDto findPais(Pais pais);
    public void deletePais(Pais pais);
    public PaisDto uptadePais(Pais pais);
    public Optional<Pais> findPaisById(Integer idPais);
    public void deletePais(Integer id);
    public PaisDto findById(Integer id);
}