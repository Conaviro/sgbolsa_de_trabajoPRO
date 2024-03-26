package com.ug.ec.controller;

import com.ug.ec.domain.Pais;
import com.ug.ec.servicio.IPaisService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;
import com.ug.ec.dto.PaisDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class PaisController {
    
    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IPaisService servicePais;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @GetMapping("/pais")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaPais() {
        List<PaisDto> listaPaisdto = servicePais.findAll();
        if (listaPaisdto != null) {
            if (listaPaisdto.size() != 0) {
                return new ResponseEntity<>(listaPaisdto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/crear_pais")
    public ResponseEntity<?> agregarPais(@RequestBody Pais pais) {
        servicePais.save(pais);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_pais/{id}")
    public ResponseEntity<?> updatePais(@PathVariable(value = "id") Integer id, @RequestBody Pais pais) {
        Pais paisDb = null;
        PaisDto paisDto = servicePais.findById(id);
        paisDb = mapper.map(paisDto, Pais.class);
        if (paisDb != null) {
            paisDb.setNombrePais(pais.getNombrePais());
//            paisDb.setIdCiudad(pais.getIdCiudad());
            paisDto = servicePais.uptadePais(paisDb);
            return new ResponseEntity<>(paisDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
