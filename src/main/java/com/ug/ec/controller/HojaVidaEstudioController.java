
package com.ug.ec.controller;


import com.ug.ec.domain.Estudio;
import com.ug.ec.domain.HojaVida;
import com.ug.ec.model.HojaVidaEstudio;

import com.ug.ec.servicio.IEstudioService;
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
public class HojaVidaEstudioController {
    
     @Autowired
    private IHojaVidaService hojaVidaService;
     
     @Autowired
    private IEstudioService serviceEstudio;
     
//     @PostMapping("/hojavida_estudio")
//    public ResponseEntity<?> listaHojaVidaEstudio(@RequestBody HojaVida hojavida) {
//        HojaVida hojavidaDb = hojaVidaService.findById(hojavida.getIdHojaVida() );
//        if (hojavidaDb != null) {
//            Collection<Estudio> listaEstudio = hojavidaDb.getEstudio();
//            if (listaEstudio != null) {
//                return new ResponseEntity<>(listaEstudio, HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping("/save_hojavida_estudio")
//    public ResponseEntity<?> saveHojaVidaExperiencia(@RequestBody HojaVidaEstudio hojaVidaEstudio) {
//        HojaVida hojavidaDb = hojaVidaService.findById(hojaVidaEstudio.getHojavida().getIdHojaVida());
//        if (hojavidaDb != null) {            
//
//            Estudio estudioDb = serviceEstudio.findById(hojaVidaEstudio.getEstudio().getIdEstudio() );
//            hojavidaDb.addEstudio(estudioDb);          
//            
//      
//            hojaVidaService.save(hojavidaDb);
//            return new ResponseEntity<Void>(HttpStatus.CREATED); 
//        }
//        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//    }
    
}
