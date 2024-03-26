package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.Estudio;
import com.ug.ec.dto.EstudioDto;
//import com.ug.ec.model.requests.EstudioRequestModel;
//import com.ug.ec.model.responses.EstudioResponsesModel;
import com.ug.ec.servicio.IEstudioService;
import java.util.ArrayList;
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
public class EstudioController {
    
    @Autowired
    private IEstudioService serviceEstudio;
    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    @GetMapping("/estudio")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaEstudio() {
        List<EstudioDto> estudioDto = serviceEstudio.findAll();
        if (estudioDto != null) {
            if (estudioDto.size() != 0) {
                return new ResponseEntity<>(estudioDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_estudio")
    public ResponseEntity<?> agregarEstudio(@RequestBody Estudio estudio) {
        serviceEstudio.save(estudio);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_estudio/{id}")
    public ResponseEntity<?> updateEstudio(@PathVariable(value = "id") Integer id, @RequestBody @Valid Estudio estudio) {
        Estudio estudioDb = null;
        //EstudioResponsesModel estudioReturn;
        EstudioDto estudioDto= serviceEstudio.findById(id);
        estudioDb = mapper.map(estudioDto, Estudio.class);
        if (estudioDb != null) {
            estudioDb.setInstitucion(estudio.getInstitucion());
            estudioDb.setTitulo(estudio.getTitulo());
            //estudioDb.setIdNivel(estudio.getIdNivel());
            //estudioDb.setIdPais(estudio.getIdPais());
            estudioDto = serviceEstudio.uptadeEstudio(estudioDb);
            return new ResponseEntity<>(estudioDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
