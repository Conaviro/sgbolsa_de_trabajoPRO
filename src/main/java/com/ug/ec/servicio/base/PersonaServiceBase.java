package com.ug.ec.servicio.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ug.ec.dao.DireccionDao;
import com.ug.ec.dao.HojaVidaDao;
import com.ug.ec.dao.PersonaDao;
import com.ug.ec.domain.HojaVida;
import com.ug.ec.domain.Persona;
import com.ug.ec.dto.PersonaDto;
import com.ug.ec.servicio.IPersonaService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceBase implements IPersonaService {

    @Autowired
    private HojaVidaServiceBase hojaVidaServiceBase;

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private DireccionDao direccionDao;

    @Autowired
    private HojaVidaDao hojavidaDao;

    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    @Override
    @Transactional(readOnly = true)
    public List<PersonaDto> findAll() {

        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        //List<PersonaDto> personaDtos =new ArrayList<>();//08022024
        List<PersonaDto> personaDtos = gson.fromJson(gson.toJson(personaDao.findAll()), ArrayList.class);
//        List<PersonaDto> personaDirDtos = new ArrayList<>();
//       for (Persona persona : personaDao.findAll()) {
//            PersonaDto objDto = mapper.map(persona, PersonaDto.class);
//            objDto.setDireccion(direccionDao.findByPersona(persona.getIdPersona()));
//            personaDirDtos.add(objDto);
//        }
//08022024

//        List<PersonaDto> personaDirDtos = new ArrayList<>();
//        Iterator it = personaDao.findAll().iterator();
//        Persona perso = null;
//        PersonaDto persoDto = null;
//        Iterator it = personaDtos.iterator();
//        try {
//
//            while (it.hasNext()) {
//                persoDto = new PersonaDto();
//                persoDto = (PersonaDto) it.next();
//                //persoDto.setApellido(perso.getApellido());
//                persoDto.setDireccion(direccionDao.findByPersona(persoDto.getIdPersona()));
//                personaDirDtos.add(persoDto);
//                //personaDirDtos.;
//
//            }
//        } catch (Exception e) {
//        
//        }
        //08022024 
        //  List<PersonaDto> personaDirDtos = gson.fromJson(gson.toJson(personaDtos), ArrayList.class);

//                 new ArrayList<>();
//
//        for (Persona persona : personaDao.findAll()) {
//            PersonaDto objDto = mapper.map(persona, PersonaDto.class);
//            personaDtos.add(objDto);
//        }
        return personaDtos; //personaDtos;// personaDirDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaDto[] findPAll() {
        PersonaDto[] personaDtos = gson.fromJson(gson.toJson(personaDao.findAll()), PersonaDto[].class);
        return personaDtos;
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {

        //Persona personaEnty = mapper.map(persona, Persona.class);
        HojaVida hojavida = new HojaVida();

        persona = personaDao.save(persona);

        hojavida.setPersona(persona);

        if (hojaVidaServiceBase.findHojaVidaPersona(persona.getIdPersona()) == null) {
            hojavidaDao.save(hojavida);
        }

        return persona;

        //Persona objDto = mapper.map(personaEnty, PersonaDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaDto findPersona(Persona persona) {

        Persona personaEnty = personaDao.findById(persona.getIdPersona()).orElse(null);
        PersonaDto objDto = gson.fromJson(gson.toJson(personaEnty), PersonaDto.class);//mapper.map(personaEnty, PersonaDto.class);

        return objDto;
    }

    @Override
    @Transactional
    public void deletePersona(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional
    public PersonaDto uptadePersona(Persona persona) {
        HojaVida hojavida = new HojaVida();
        Persona personaEnty = (Persona) personaDao.save(persona);

        if (hojaVidaServiceBase.findHojaVidaPersona(persona.getIdPersona()) == null) {
            hojavida.setPersona(persona);
            hojavidaDao.save(hojavida);

        }

        // PersonaDto objDto = mapper.map(personaEnty, PersonaDto.class);
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        PersonaDto objDto = gson.fromJson(gson.toJson(personaEnty), PersonaDto.class);//

        return objDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findPersonaById(Long idPersona) {
        return (Optional<Persona>) personaDao.findById(idPersona);
    }

    @Override
    @Transactional
    public void deletePersona(Long id) {
        personaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaDto findById(Long id) {

        Persona personaEnty = personaDao.findById(id).orElse(null);
        PersonaDto objDto = mapper.map(personaEnty, PersonaDto.class);
        // PersonaDto objDto = gson.fromJson(gson.toJson(personaEnty), PersonaDto.class);//

        return objDto;
    }

}
