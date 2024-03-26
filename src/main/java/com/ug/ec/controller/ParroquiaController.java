package com.ug.ec.controller;

import com.ug.ec.domain.Parroquia;
import com.ug.ec.servicio.IParroquiaService;
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
import com.ug.ec.dto.ParroquiaDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class ParroquiaController {
    
    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IParroquiaService serviceParroquia;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @GetMapping("/parroquia")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaParroquia() {
        List<ParroquiaDto> listaParroquiadto = serviceParroquia.findAll();
        if (listaParroquiadto != null) {
            if (listaParroquiadto.size() != 0) {
                return new ResponseEntity<>(listaParroquiadto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/crear_parroquia")
    public ResponseEntity<?> agregarParroquia(@RequestBody Parroquia parroquia) {
        serviceParroquia.save(parroquia);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_parroquia/{id}")
    public ResponseEntity<?> updateParroquia(@PathVariable(value = "id") Integer id, @RequestBody Parroquia parroquia) {
        Parroquia parroquiaDb = null;
        ParroquiaDto parroquiaDto = serviceParroquia.findById(id);
        parroquiaDb = mapper.map(parroquiaDto, Parroquia.class);
        if (parroquiaDb != null) {
            parroquiaDb.setNombreParroquia(parroquia.getNombreParroquia());
            //parroquiaDb.setIdCanton(parroquia.getIdCanton());
            parroquiaDto = serviceParroquia.uptadeParroquia(parroquiaDb);
            return new ResponseEntity<>(parroquiaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
