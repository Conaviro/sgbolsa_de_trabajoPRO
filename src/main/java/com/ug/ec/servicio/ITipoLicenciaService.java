
package com.ug.ec.servicio;

import com.ug.ec.domain.TipoLicencia;
import com.ug.ec.dto.TipoLicenciaDto;
import java.util.List;
import java.util.Optional;

public interface ITipoLicenciaService {
        public List<TipoLicenciaDto> findAll();

    public TipoLicenciaDto save(TipoLicenciaDto tipolicencia);

    public TipoLicenciaDto findTipoLicencia(TipoLicenciaDto tipolicencia);

    public void deleteTipoLicencia(TipoLicencia tipolicencia);

    public TipoLicenciaDto uptadeTipoLicencia(TipoLicencia tipolicencia);

    public Optional<TipoLicencia> findTipoLicenciaById(Integer idTipoLicencia);

    public void deleteTipoLicencia(Integer id);

    public TipoLicenciaDto findById(Integer id);

}
