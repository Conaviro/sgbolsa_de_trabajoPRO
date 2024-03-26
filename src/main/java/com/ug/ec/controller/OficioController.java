package com.ug.ec.controller;

import com.ug.ec.domain.Oficio;
import com.ug.ec.dto.OficioDto;
import com.ug.ec.servicio.IOficioService;
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
public class OficioController {

    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IOficioService serviceOficio;

    @Autowired
    ModelMapper mapper;
    
    @GetMapping("/oficio")
    public ResponseEntity<?> listaOficio() {
        List<OficioDto> listaOficio = serviceOficio.findAll();
        System.out.println(serviceOficio.findAll());
        if (listaOficio != null) {
            if (listaOficio.size() != 0) {
                return new ResponseEntity<>(listaOficio, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear_oficio")
    public ResponseEntity<?> agregarOficio(@RequestBody Oficio oficio) {
        serviceOficio.save(oficio);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_oficio/{id}")
    public ResponseEntity<?> updateOficio(@PathVariable(value = "id") Integer id, @RequestBody Oficio oficio) {
        Oficio oficioDb = null;
        OficioDto oficioDto = serviceOficio.findById(id);
        
        oficioDb = mapper.map(oficioDto, Oficio.class);

        if (oficioDb != null) {

            oficioDb.setDescripcion(oficio.getDescripcion());

            oficioDto = serviceOficio.uptadeOficio(oficioDb);
            return new ResponseEntity<>(oficioDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
