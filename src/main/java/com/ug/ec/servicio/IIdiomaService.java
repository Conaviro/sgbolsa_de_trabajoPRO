package com.ug.ec.servicio;

import com.ug.ec.domain.Idioma;
import com.ug.ec.dto.IdiomaDto;
import java.util.List;
import java.util.Optional;

public interface IIdiomaService {
    public List<IdiomaDto> findAll();
    public void save(Idioma idioma);
    public IdiomaDto findIdioma(Idioma idioma);
    public void deleteIdioma(Idioma idioma);
    public IdiomaDto uptadeIdioma(Idioma idioma);
    public Optional<Idioma> findIdiomaById(Integer idIdioma);
    public void deleteIdioma(Integer id);
    public IdiomaDto findById(Integer id);
}
