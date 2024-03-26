package com.ug.ec.servicio;

import com.ug.ec.domain.Oferta;
import com.ug.ec.dto.OfertaDto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOfertaService {

    public List<OfertaDto> findAll();

    public void save(Oferta oferta);

    public OfertaDto findOferta(Oferta oferta);

    public void deleteOferta(Oferta oferta);

    public OfertaDto uptadeOferta(Oferta oferta);

    public Optional<Oferta> findOfertaById(Long idOferta);

    public void deleteOferta(Long id);

    public OfertaDto findById(Long id);

    List<OfertaDto> buscarDestacadas();
//	Page<Vacante> buscarTodas(Pageable page);

    List<OfertaDto> buscarByExample(Example<Oferta> example);
}
