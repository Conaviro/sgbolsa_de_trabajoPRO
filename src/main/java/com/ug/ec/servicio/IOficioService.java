package com.ug.ec.servicio;

import com.ug.ec.domain.Oficio;
import com.ug.ec.dto.OficioDto;
import java.util.List;
import java.util.Optional;

public interface IOficioService {

    public List<OficioDto> findAll();

    public void save(Oficio oficio);

    public OficioDto findOficio(Oficio oficio);

    public void deleteOficio(Oficio oficio);

    public OficioDto uptadeOficio(Oficio oficio);

    public Optional<Oficio> findOficioById(Integer idOficio);

    public void deleteOficio(Integer id);

    public OficioDto findById(Integer id);

    public Oficio findByIdOf(Integer id);
}
