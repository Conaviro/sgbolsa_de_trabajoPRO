package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.Nivel;
import com.ug.ec.dto.NivelDto;
import com.ug.ec.servicio.INivelService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class NivelController {
    
    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private INivelService serviceNivel;
    
    @Autowired
    ModelMapper mapper;

    @GetMapping("/nivel")
    public ResponseEntity<?> listaNivel() {
        List<NivelDto> listaNivel = serviceNivel.findAll();
        System.out.println(serviceNivel.findAll());
        if (listaNivel != null) {
            if (listaNivel.size() != 0) {
                return new ResponseEntity<>(listaNivel, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/crear_nivel")
    public ResponseEntity<?> agregarNivel(@RequestBody Nivel nivel) {
        serviceNivel.save(nivel);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_nivel/{id}")
    public ResponseEntity<?> updateNivel(@PathVariable(value = "id") Integer id, @RequestBody Nivel nivel) {
        Nivel nivelDb = null;
        
        
        NivelDto nivelDto = serviceNivel.findById(id);
        
        nivelDb = mapper.map(nivelDto, Nivel.class);
        if (nivelDb != null) {
            nivelDb.setNivelEstudio(nivel.getNivelEstudio());
            nivelDto = serviceNivel.uptadeNivel(nivelDb);
            
            return new ResponseEntity<>(nivelDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
