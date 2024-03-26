package com.ug.ec.controller;

import com.ug.ec.domain.Canton;
import com.ug.ec.servicio.ICantonService;
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
import com.ug.ec.dto.CantonDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class CantonController {
    
    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private ICantonService serviceCanton;

    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @GetMapping("/canton")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaCanton() {
        List<CantonDto> listaCantondto = serviceCanton.findAll();
        if (listaCantondto != null) {
            if (listaCantondto.size() != 0) {
                return new ResponseEntity<>(listaCantondto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/crear_canton")
    public ResponseEntity<?> agregarCanton(@RequestBody Canton canton) {
        serviceCanton.save(canton);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_canton/{id}")
    public ResponseEntity<?> updateCanton(@PathVariable(value = "id") Integer id, @RequestBody Canton canton) {
        Canton cantonDb = null;
        CantonDto cantonDto = serviceCanton.findById(id);
        cantonDb = mapper.map(cantonDto, Canton.class);
        if (cantonDb != null) {
           // cantonDb.setNombreCanton(canton.getNombreCanton());
//            cantonDb.setIdProvincia(canton.getIdProvincia());
            cantonDto = serviceCanton.uptadeCanton(cantonDb);
            return new ResponseEntity<>(cantonDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
