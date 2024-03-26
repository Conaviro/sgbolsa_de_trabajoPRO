package com.ug.ec.servicio.base;

import com.ug.ec.dao.GrupoDao;
import com.ug.ec.domain.Grupo;
import com.ug.ec.dto.GrupoDto;
import com.ug.ec.servicio.IGrupoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GrupoServiceBase implements IGrupoService {

    @Autowired
    private GrupoDao grupoDao;
    @Autowired
    ModelMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<GrupoDto> findAll() {

        List<GrupoDto> grupoDtos = new ArrayList<>();

        for (Grupo grupo : grupoDao.findAll()) {
            GrupoDto objDto = mapper.map(grupo, GrupoDto.class);
            grupoDtos.add(objDto);
        }

        return grupoDtos;
    }

    @Override
    @Transactional
    public GrupoDto save(GrupoDto grupo) {

        Grupo grupoEnty = mapper.map(grupo, Grupo.class);
        grupoDao.save(grupoEnty);
        GrupoDto objDto = mapper.map(grupoEnty, GrupoDto.class);

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public GrupoDto findGrupo(GrupoDto grupo) {

        Grupo grupoEnty = grupoDao.findById(grupo.getIdGrupo()).orElse(null);
        GrupoDto objDto = mapper.map(grupoEnty, GrupoDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteGrupo(Grupo grupo) {
        grupoDao.delete(grupo);
    }

    @Override
    @Transactional
    public GrupoDto uptadeGrupo(Grupo grupo) {

        Grupo grupoEnty = grupoDao.save(grupo);
        GrupoDto objDto = mapper.map(grupoEnty, GrupoDto.class);

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Grupo> findGrupoById(Integer idGrupo) {
        return (Optional<Grupo>) grupoDao.findById(idGrupo);
    }

    @Override
    @Transactional
    public void deleteGrupo(Integer id) {
        grupoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public GrupoDto findById(Integer id) {

        Grupo grupoEnty = grupoDao.findById(id).orElse(null);
        GrupoDto objDto = mapper.map(grupoEnty, GrupoDto.class);
        return objDto;

    }
}