package com.ug.ec.servicio;

import com.ug.ec.domain.Nivel;
import com.ug.ec.dto.NivelDto;
import java.util.List;
import java.util.Optional;

public interface INivelService {    
    public List<NivelDto> findAll();
    public void save(Nivel nivel);
    public NivelDto findNivel(Nivel nivel);
    public void deleteNivel(Nivel nivel);
    public NivelDto uptadeNivel(Nivel nivel);
    public Optional<Nivel> findNivelById(Integer idNivel);
    public void deleteNivel(Integer id);
    public NivelDto findById(Integer id);
    
}
