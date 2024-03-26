package com.ug.ec.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.ug.ec.domain.Comunidad;
import com.ug.ec.dto.ComunidadDto;
import com.ug.ec.model.requests.ComunidadRequestModel;
import com.ug.ec.model.responses.ComunidadResponsesModel;
import com.ug.ec.servicio.IComunidadService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.common.utils.config.exception.GeneralException;
import com.google.gson.Gson;
import com.ug.ec.domain.Area;
import com.ug.ec.dto.AreaDto;
import com.ug.ec.dto.ComunidadDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseStatus;

//@Controller
//@Component
@RestController
@Slf4j
@RequestMapping("/bolsatrabajo")
public class ComunidadController {

    @Autowired
    private IComunidadService serviceComunidad;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @GetMapping(value = "/comunidad", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaComunidad() {
    List<ComunidadDto> listaComunidaddto = serviceComunidad.findAll();
        if (listaComunidaddto != null) {
            if (listaComunidaddto.size() != 0) {
                return new ResponseEntity<>(listaComunidaddto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

   //, consumes = "application/json"
    @PostMapping("/crear_comunidad")
    public ResponseEntity<?> agregarComunidad(@RequestBody @Valid Comunidad comunidad) {

        //Comunidad comunidadReturn = gson.fromJson(gson.toJson(comunidad), Comunidad.class);
        serviceComunidad.save(comunidad);

       return new ResponseEntity<Void>(HttpStatus.CREATED);

       

    }
//headers = "content-type=multipart/*", consumes = "application/*"
    //@Produces({ "application/json; charset=utf-8"})
//	@ApiOperation(value="post Customers", notes ="Service for post Customers")
    //(path = "/update_comunidad/{id}", consumes = {"application/json; charset=utf-8"}

    //@PutMapping("/update_comunidad/{id}")
    @PutMapping(path = "/update_comunidad/{id}", consumes = {"application/json; charset=utf-8"})
    public ResponseEntity<?> updateComunidad(@PathVariable(value = "id") Integer id, @RequestBody @Valid Comunidad comunidad) throws ParseException {
        Comunidad comunidadDb = null;
        ComunidadDto comunidadDto = serviceComunidad.findById(id);
        comunidadDb = mapper.map(comunidadDto, Comunidad.class);
        if (comunidadDb != null) {
            comunidadDb.setComunidad(comunidad.getComunidad());
            comunidadDb.setEstatus(comunidad.getEstatus());
            comunidadDb.setImagen(comunidad.getImagen());
            
            comunidadDb.setGrupo(comunidad.getGrupo());
            comunidadDto = serviceComunidad.uptadeComunidad(comunidadDb);
            return new ResponseEntity<>(comunidadDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
