
package com.ug.ec.servicio;


import com.ug.ec.domain.Persona;
import com.ug.ec.dto.PersonaDto;
import java.util.List;
import java.util.Optional;


public interface IPersonaService {
   public List<PersonaDto> findAll();
   public PersonaDto[] findPAll();
    public Persona save(Persona persona);
    public PersonaDto findPersona(Persona persona);
    public void deletePersona(Persona persona);
    public PersonaDto uptadePersona(Persona persona);
    public Optional<Persona> findPersonaById(Long idPersona);
    public void deletePersona(Long id);
    public PersonaDto findById(Long id); 
}
