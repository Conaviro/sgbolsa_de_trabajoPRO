package com.ug.ec.servicio;


import com.ug.ec.domain.Grupo;
import com.ug.ec.dto.GrupoDto;
import java.util.List;
import java.util.Optional;


public interface IGrupoService {
    public List<GrupoDto> findAll();
    public GrupoDto save(GrupoDto grupo);
    public GrupoDto findGrupo(GrupoDto grupo);
    public void deleteGrupo(Grupo grupo);
    public GrupoDto uptadeGrupo(Grupo grupo);
    public Optional<Grupo> findGrupoById(Integer idGrupo);
    public void deleteGrupo(Integer id);
    public GrupoDto findById(Integer id);
}