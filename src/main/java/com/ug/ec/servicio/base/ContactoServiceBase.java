
package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.ug.ec.dao.ContactoDao;
import com.ug.ec.domain.Contacto;
import com.ug.ec.dto.ContactoDto;
import com.ug.ec.servicio.IContactoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoServiceBase implements IContactoService{
    
    @Autowired
    private ContactoDao contactoDao;
    
    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;
    
    @Override
    @Transactional(readOnly = true)
    public List<ContactoDto> findAll() {
        
        List<ContactoDto> contactoDtos = gson.fromJson(gson.toJson(contactoDao.findAll()), ArrayList.class);
        
        return contactoDtos;
    }

    @Override
    @Transactional
    public void save(Contacto contacto) {
         contactoDao.save(contacto);
    }

    @Override
    @Transactional(readOnly = true)
    public ContactoDto findContacto(Contacto contacto) {
         
        Contacto contactoEnty = contactoDao.findById(contacto.getIdContacto()).orElse(null);
        ContactoDto objDto = gson.fromJson(gson.toJson(contactoEnty), ContactoDto.class);//mapper.map(personaEnty, PersonaDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deleteContacto(Contacto contacto) {
        contactoDao.delete(contacto);
    }

    @Override
    @Transactional
    public ContactoDto uptadeContacto(Contacto contacto) {
        
       Contacto contactoEnty = (Contacto) contactoDao.save(contacto);
       ContactoDto objDto = gson.fromJson(gson.toJson(contactoEnty), ContactoDto.class);
        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contacto> findContactoById(Integer idContacto) {
        return (Optional<Contacto>)contactoDao.findById(idContacto);
    }

    @Override
    @Transactional
    public void deleteContacto(Integer id) {
        contactoDao.deleteById(id); 
    }

    @Override
    @Transactional(readOnly = true)
    public ContactoDto findById(Integer id) {
        
        Contacto contactoEnty = contactoDao.findById(id).orElse(null);
       // PersonaDto objDto = mapper.map(personaEnty, PersonaDto.class);
       ContactoDto objDto = gson.fromJson(gson.toJson(contactoEnty), ContactoDto.class);//

        return objDto;
    }
}
