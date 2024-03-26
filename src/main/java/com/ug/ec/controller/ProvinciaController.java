package com.ug.ec.controller;

import com.ug.ec.domain.Provincia;
import com.ug.ec.servicio.IProvinciaService;
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
import com.ug.ec.dto.ProvinciaDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class ProvinciaController {
    
    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IProvinciaService serviceProvincia;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    @GetMapping("/provincia")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaProvincia() {
        // var pais=paisDao.findAll();//paisService.listarPais();
        List<ProvinciaDto> listaProvinciadto = serviceProvincia.findAll();
        if (listaProvinciadto != null) {
            if (listaProvinciadto.size() != 0) {
                return new ResponseEntity<>(listaProvinciadto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_provincia")
    public ResponseEntity<?> agregarProvincia(@RequestBody Provincia provincia) {
        serviceProvincia.save(provincia);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_provincia/{id}")
    public ResponseEntity<?> updateProvincia(@PathVariable(value = "id") Integer id, @RequestBody Provincia provincia) {
        Provincia provinciaDb = null;
        ProvinciaDto provinciaDto = serviceProvincia.findById(id);
        provinciaDb = mapper.map(provinciaDto, Provincia.class);
        if (provinciaDb != null) {
            provinciaDb.setNombreProvincia(provincia.getNombreProvincia());
            provinciaDto = serviceProvincia.uptadeProvincia(provinciaDb);
            return new ResponseEntity<>(provinciaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
