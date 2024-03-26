
package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.TipoDireccion;
import com.ug.ec.dto.TipoDireccionDto;
import com.ug.ec.servicio.ITipoDireccionService;
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
public class TipoDireccionController {
      // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private ITipoDireccionService serviceTipoDireccion;

    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;
    
    @GetMapping("/tipodireccion")
    public ResponseEntity<?> listaTipoDireccion() {
        // var pais=paisDao.findAll();//paisService.listarPais();
        List<TipoDireccionDto> tipoDireccionDto = serviceTipoDireccion.findAll();
        if (tipoDireccionDto != null) {
            if (tipoDireccionDto.size() != 0) {
                return new ResponseEntity<>(tipoDireccionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_tipodireccion")
	public ResponseEntity<?> agregarTipoDireccion(@RequestBody TipoDireccion tipodireccion){
		serviceTipoDireccion.save(tipodireccion); 
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

   

    @PutMapping("/update_tipodireccion/{id}")
    public ResponseEntity<?> updateTipoDireccion(@PathVariable(value = "id") Integer id, @RequestBody TipoDireccion tipodireccion) {
        TipoDireccion tipodireccionDb = null;
        
        //tipodireccionDb = serviceTipoDireccion.findById(id);
        TipoDireccionDto tipoDireccionDto = serviceTipoDireccion.findById(id);
        tipodireccionDb = mapper.map(tipoDireccionDto, TipoDireccion.class);
        
        if (tipodireccionDb != null) {
            tipodireccionDb.setNombreTipoDireccion(tipodireccion.getNombreTipoDireccion());
            
            tipoDireccionDto= serviceTipoDireccion.uptadeTipoDireccion(tipodireccionDb);
            return new ResponseEntity<>(tipoDireccionDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
  
    
}
