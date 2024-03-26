package com.ug.ec.servicio;

import com.ug.ec.domain.Parroquia;
import java.util.List;
import java.util.Optional;
import com.ug.ec.dto.ParroquiaDto;

public interface IParroquiaService {
    public List<ParroquiaDto> findAll();
    public void save(Parroquia parroquia);
    public ParroquiaDto findParroquia(Parroquia parroquia);
    public void deleteParroquia(Parroquia parroquia);
    public ParroquiaDto uptadeParroquia(Parroquia parroquia);
    public Optional<Parroquia> findParroquiaById(Integer idParroquia);
    public void deleteParroquia(Integer id);
    public ParroquiaDto findById(Integer id);
}
