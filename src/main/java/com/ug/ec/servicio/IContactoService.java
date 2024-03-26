
package com.ug.ec.servicio;

import com.ug.ec.domain.Contacto;
import com.ug.ec.dto.ContactoDto;
import java.util.List;
import java.util.Optional;

public interface IContactoService {
    
    public List<ContactoDto> findAll();

    public void save(Contacto contacto);

    public ContactoDto findContacto(Contacto contacto);

    public void deleteContacto(Contacto contacto);

    public ContactoDto uptadeContacto(Contacto contacto);

    public Optional<Contacto> findContactoById(Integer idContacto);

    public void deleteContacto(Integer id);

    public ContactoDto findById(Integer id);

}
