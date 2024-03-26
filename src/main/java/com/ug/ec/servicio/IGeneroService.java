package com.ug.ec.servicio;


import com.ug.ec.domain.Genero;
import com.ug.ec.dto.GeneroDto;
import java.util.List;
import java.util.Optional;

public interface IGeneroService {

    public List<GeneroDto> findAll();

    public GeneroDto save(GeneroDto genero);

    public GeneroDto findGenero(GeneroDto genero);

    public void deleteGenero(Genero genero);

    public GeneroDto uptadeGenero(Genero genero);

    public Optional<Genero> findGeneroById(Integer idGenero);

    public void deleteGenero(Integer id);

    public GeneroDto findById(Integer id);

}