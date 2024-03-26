
package com.ug.ec.servicio;

import com.ug.ec.domain.Referencia;
import java.util.List;
import java.util.Optional;
import com.ug.ec.dto.ReferenciaDto;
public interface IReferenciaService {
        public List<ReferenciaDto> findAll();

    public void save(Referencia referencia);

    public ReferenciaDto findReferencia(Referencia referencia);

    public void deleteReferencia(Referencia referencia);

    public ReferenciaDto uptadeReferencia(Referencia referencia);

    public Optional<Referencia> findReferenciaById(Integer idReferencia);

    public void deleteReferencia(Integer id);

    public ReferenciaDto findById(Integer id);

}
