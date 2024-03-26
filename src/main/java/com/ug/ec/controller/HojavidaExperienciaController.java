
package com.ug.ec.controller;

import com.ug.ec.domain.Experiencia;
import com.ug.ec.domain.HojaVida;
import com.ug.ec.model.HojaVidaExperiencia;
import com.ug.ec.servicio.IExperienciaService;
import com.ug.ec.servicio.IHojaVidaService;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class HojavidaExperienciaController {
    
    
     @Autowired
    private IHojaVidaService hojaVidaService;

    @Autowired
    private IExperienciaService experienciaService;

    
//    @PostMapping("/hojavida_experiencia")
//    public ResponseEntity<?> listaHojaVidaExperiencia(@RequestBody HojaVida hojavida) {
//        HojaVida hojavidaDb = hojaVidaService.findById(hojavida.getIdHojaVida() );
//        if (hojavidaDb != null) {
//            Collection<Experiencia> listaExperiencia = hojavidaDb.getExperiencia();
//            if (listaExperiencia != null) {
//                return new ResponseEntity<>(listaExperiencia, HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping("/save_hojavida_experiencia")
//    public ResponseEntity<?> saveHojaVidaExperiencia(@RequestBody HojaVidaExperiencia hojaVidaExperiencia) {
//        HojaVida hojavidaDb = hojaVidaService.findById(hojaVidaExperiencia.getHojavida().getIdHojaVida());
//        if (hojavidaDb != null) {            
//
//            Experiencia experienciaDb = experienciaService.findById(hojaVidaExperiencia.getExperiencia().getIdExperiencia() );
//            hojavidaDb.addExperiencia(experienciaDb);           
//            
//      
//            hojaVidaService.save(hojavidaDb);
//            return new ResponseEntity<Void>(HttpStatus.CREATED); 
//        }
//        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//    }
}
