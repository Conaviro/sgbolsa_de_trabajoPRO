
package com.ug.ec.controller;

import com.ug.ec.domain.Conocimiento;
import com.ug.ec.servicio.IConocimientoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;
import com.ug.ec.dto.ConocimientoDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class ConocimientoController {
         // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IConocimientoService serviceConocimiento;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    @GetMapping("/conocimiento")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaConocimiento() {
        // var pais=paisDao.findAll();//paisService.listarPais();
       List<ConocimientoDto> listaConocimientodto = serviceConocimiento.findAll();
        if (listaConocimientodto != null) {
            if (listaConocimientodto.size() != 0) {
                return new ResponseEntity<>(listaConocimientodto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_conocimiento")
	public ResponseEntity<?> agregarConocimiento(@RequestBody Conocimiento conocimiento){
		serviceConocimiento.save(conocimiento); 
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

   

    @PutMapping("/update_conocimiento/{id}")
    public ResponseEntity<?> updateConocimiento(@PathVariable(value = "id") Integer id, @RequestBody Conocimiento conocimiento) {
        Conocimiento conocimientoDb = null;
        ConocimientoDto conocimientoDto = serviceConocimiento.findById(id);
        conocimientoDb = mapper.map(conocimientoDto, Conocimiento.class);
        if (conocimientoDb != null) {
            conocimientoDb.setDescripcionConocimiento(conocimiento.getDescripcionConocimiento());
            conocimientoDto = serviceConocimiento.uptadeConocimiento(conocimientoDb);
            return new ResponseEntity<>(conocimientoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    
}
