package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.dao.DireccionDao;
import com.ug.ec.domain.Area;
import com.ug.ec.domain.Persona;
import com.ug.ec.dto.PersonaDto;
import com.ug.ec.model.requests.PersonaRequestModel;
import com.ug.ec.model.responses.PersonaResponsesModel;
import com.ug.ec.servicio.IPersonaService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class PersonaController {

    @Autowired
    private IPersonaService servicePersona;

    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @Autowired
    private DireccionDao direccionDao;

    @GetMapping("/persona")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaPersona() {

        List<PersonaDto> personaDto = servicePersona.findAll(); //if (personaDto.size() != 0) {
        //PersonaDto[] personaDto = servicePersona.findPAll();
//        List<PersonaDto> personaDirDtos = new ArrayList<>();
//        
//        PersonaDto persoDto = null;
//        Iterator it = personaDto.iterator();
//        try {
//
//            while (it.hasNext()) {
//                
//                persoDto =  (PersonaDto) it.next();
//                //persoDto.setApellido(perso.getApellido());
//                persoDto.setDireccion(direccionDao.findByPersona(persoDto.getIdPersona()));
//                personaDirDtos.add(persoDto);
//                //personaDirDtos.;
//
//            }
//        } catch (Exception e) {
//        
//        }
        

        if (personaDto != null) {
            if (personaDto.size() != 0) {
                return new ResponseEntity<>(personaDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

//    @PostMapping("/crear_persona")
//    public ResponseEntity<?> agregarPersona(@RequestBody @Valid Persona persona) {
//       
//        
//        servicePersona.save(persona);
//        return new ResponseEntity<Void>(HttpStatus.CREATED);
//        
//    }
    @PostMapping("/crear_persona")
    public ResponseEntity<?> agregarPersona(@RequestBody @Valid Persona persona) {

        //Comunidad comunidadReturn = gson.fromJson(gson.toJson(comunidad), Comunidad.class);
        //serviceComunidad.save(comunidad);
        Persona personaBd = servicePersona.save(persona);

        // return new ResponseEntity<Void>(HttpStatus.CREATED);
        return new ResponseEntity<>(personaBd, HttpStatus.CREATED);

    }

    @PutMapping("/update_persona/{id}")
    public ResponseEntity<?> updatePersona(@PathVariable(value = "id") Long id, @RequestBody @Valid Persona persona) {
        Persona personaDb = new Persona();

        //PersonaResponsesModel personaReturn;
        PersonaDto personaDto=servicePersona.findById(id);
         
        personaDb = mapper.map(personaDto, Persona.class);

        if (personaDb != null) {
             personaDb.setNombre(persona.getNombre());
            personaDb.setApellido(persona.getApellido());
            personaDb.setComunidad(persona.getComunidad());
          //   personaDb.setDireccion(persona.getDireccion());
            personaDb.setDiscapacidad(persona.getDiscapacidad());
            personaDb.setEmail(persona.getEmail());
            personaDb.setEstadoCivil(persona.getEstadoCivil());
            personaDb.setEstatus(persona.getEstatus());
            personaDb.setFechaNacimiento(persona.getFechaNacimiento());
            personaDb.setFoto(persona.getFoto());
            personaDb.setGenero(persona.getGenero());
            //personaDb.setHojaVida(persona.getHojaVida());
            personaDb.setIdentificacion(persona.getIdentificacion());
            personaDb.setLicencia(persona.getLicencia());
            personaDb.setOferta(persona.getOferta());
            personaDb.setTipoIdentificacion(persona.getTipoIdentificacion());
            personaDb.setTipoVehiculo(persona.getTipoVehiculo());
            personaDb.setViajar(persona.getViajar());

            personaDto = servicePersona.uptadePersona(personaDb);

            return new ResponseEntity<>(personaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletepersona/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable(value = "id") Long id) {
        if (servicePersona.findById(id) != null) {
            servicePersona.deletePersona(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/find_persona_id/{id}")
    public ResponseEntity<?> findPersonaId(@PathVariable("id") Long id) {
        PersonaDto personaDb = servicePersona.findById(id);

        if (personaDb != null) {
            return new ResponseEntity<>(personaDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
