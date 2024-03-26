package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.dto.DireccionDto;
import com.ug.ec.domain.Direccion;
import com.ug.ec.domain.DireccionPk;
import com.ug.ec.servicio.IDireccionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
public class DireccionController {

    @Autowired
    private IDireccionService serviceDireccion;

    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    @GetMapping("/direccion")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaDireccion() {

        List<DireccionDto> direccionDto = serviceDireccion.findAll();

        if (direccionDto != null) {
            if (direccionDto.size() != 0) {
                return new ResponseEntity<>(direccionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/find_direccion_id/{id}")
    public ResponseEntity<?> findDireccionId(@PathVariable("id") DireccionPk id) {
        //Persona personaDb = personaService.findIdentificacion(id);

        Direccion direccionDb = null;

        DireccionDto direccionDto = serviceDireccion.findById(id);

        if (direccionDto != null) {
            return new ResponseEntity<>(direccionDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/find_sacramento")
//    public ResponseEntity<?> findSacramento(@RequestBody Sacramento sacramento ) {
//        Sacramento sacramentoDb = sacramentoService.findSacramento(sacramento);
//
//        if (sacramentoDb != null) {
//            return new ResponseEntity<>(sacramentoDb, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//        }
//    }
    @PostMapping("/find_direccion_pk")
    public ResponseEntity<Optional> findOptDireccionPK(@RequestBody DireccionPk id) {
        //Persona personaDb = personaService.findIdentificacion(id);

        DireccionDto direccionDb = null;
        // DireccionDto objDto = gson.fromJson(gson.toJson(direccionEnty), DireccionDto.class);
        Optional<DireccionDto> direccionDto = gson.fromJson(gson.toJson(serviceDireccion.findDireccionById(id)), Optional.class);

        if (direccionDto != null) {
            return new ResponseEntity<>(direccionDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear_direccion")
    public ResponseEntity<?> agregarDireccion(@RequestBody Direccion direccion) {
        serviceDireccion.save(direccion);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_direccion")
    public ResponseEntity<?> updateDireccion( Integer id, @RequestBody Direccion direccion) {
        Direccion direccionDb = new Direccion();

        DireccionDto direccionDto = null;//serviceDireccion.findById(id);

       // direccionDb = mapper.map(direccionDto, Direccion.class);
        if (direccionDb != null) {
            direccionDb.setBarrio(direccion.getBarrio());
            direccionDb.setCallePrincipal(direccion.getCallePrincipal());
            direccionDb.setCalleSecundaria(direccion.getCalleSecundaria());
            direccionDb.setCanton(direccion.getCanton());
            direccionDb.setCelular(direccion.getCelular());
            direccionDb.setExtDos(direccion.getExtDos());
            direccionDb.setExtUno(direccion.getExtUno());
            direccionDb.setLlave(direccion.getLlave());
            direccionDb.setNumeroCasa(direccion.getNumeroCasa());
            direccionDb.setParroquia(direccion.getParroquia());
            direccionDb.setProvincia(direccion.getProvincia());
            direccionDb.setTelefonoDomicilioDos(direccion.getTelefonoDomicilioDos());
            direccionDb.setTelefonoDomicilioUno(direccion.getTelefonoDomicilioUno());
            direccionDb.setUbicacionIng(direccion.getUbicacionIng());
            direccionDb.setUbicacionLat(direccion.getUbicacionLat());            
            direccionDb.setWebPage(direccion.getWebPage());

            direccionDto = serviceDireccion.uptadeDireccion(direccionDb);
            return new ResponseEntity<>(direccionDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/find_persona_idDirc/{id}")
    public ResponseEntity<?> findPersonaId(@PathVariable("id") Long id) {
       List< DireccionDto> direccionDb =  serviceDireccion.findByPersonaId(id);

        if (direccionDb != null) {
            return new ResponseEntity<>(direccionDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
