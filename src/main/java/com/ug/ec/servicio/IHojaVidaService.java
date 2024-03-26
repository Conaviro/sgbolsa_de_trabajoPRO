package com.ug.ec.servicio;

import com.ug.ec.domain.HojaVida;
import com.ug.ec.domain.OficioHoja;
import com.ug.ec.domain.Persona;
import com.ug.ec.dto.HojaVidaDto;
import com.ug.ec.dto.OficioHojaDto;
import java.util.List;
import java.util.Optional;

public interface IHojaVidaService {

    public List<HojaVidaDto> findAll();

    public void save(HojaVida hojavida);

    public HojaVidaDto findHojaVida(HojaVida hojavida);

    public Persona findHojaVidaPersona(Long id);

    public HojaVidaDto findHojaVidaPersonaId(Long id);

    public void deleteHojaVida(HojaVida hojavida);

    public HojaVidaDto uptadeHojaVida(HojaVida hojavida);

    public Optional<HojaVida> findHojaVidaById(Long idHojaVida);

    public void deleteHojaVida(Long id);

    public HojaVidaDto findById(Long id);

    public void saveOficioHoja(OficioHoja oficioHoja);

    public void deleteOficioHoja(OficioHoja oficioHoja);

    public List<OficioHoja> findOficioHojaAll();

    public List<OficioHojaDto> findOficioHojaPersonaId(Long id);

}
