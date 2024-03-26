package com.ug.ec.controller;

import com.ug.ec.domain.Referencia;
import com.ug.ec.servicio.IReferenciaService;
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
import com.ug.ec.dto.ReferenciaDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class ReferenciaController {
    
    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IReferenciaService serviceReferencia;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @GetMapping("/referencia")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaReferencia() {
        List<ReferenciaDto> listaReferenciadto = serviceReferencia.findAll();
        if (listaReferenciadto != null) {
            if (listaReferenciadto.size() != 0) {
                return new ResponseEntity<>(listaReferenciadto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/crear_referencia")
    public ResponseEntity<?> agregarReferencia(@RequestBody Referencia referencia) {
        serviceReferencia.save(referencia);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_referencia/{id}")
    public ResponseEntity<?> updateReferencia(@PathVariable(value = "id") Integer id, @RequestBody Referencia referencia) {
        Referencia referenciaDb = null;
        ReferenciaDto referenciaDto = serviceReferencia.findById(id);
        referenciaDb = mapper.map(referenciaDto, Referencia.class);
        if (referenciaDb != null) {
            referenciaDb.setNombreReferencia(referencia.getNombreReferencia());
            referenciaDb.setTelefonoReferencia(referencia.getTelefonoReferencia());
            referenciaDto = serviceReferencia.uptadeReferencia(referenciaDb);
            return new ResponseEntity<>(referenciaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
