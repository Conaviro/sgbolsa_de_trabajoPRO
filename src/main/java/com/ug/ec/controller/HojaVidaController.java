package com.ug.ec.controller;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.ug.ec.domain.Comunidad;
import com.ug.ec.domain.HojaVida;
import com.ug.ec.domain.Oficio;
import com.ug.ec.domain.OficioHoja;
import com.ug.ec.dto.HojaVidaDto;
import com.ug.ec.dto.OficioDto;
import com.ug.ec.dto.OficioHojaDto;
import com.ug.ec.servicio.IHojaVidaService;
import com.ug.ec.servicio.IOficioService;
import static java.lang.System.in;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import javax.validation.Valid;
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
public class HojaVidaController {

    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IHojaVidaService serviceHojaVida;
   
    @Autowired
    private IOficioService oficioService;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/hojavida")
    public ResponseEntity<?> listaHojaVida() {
        List<HojaVidaDto> listaHojaVida = serviceHojaVida.findAll();
        System.out.println(serviceHojaVida.findAll());
        if (listaHojaVida != null) {
            if (listaHojaVida.size() != 0) {
                return new ResponseEntity<>(listaHojaVida, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear_hojavida")
    public ResponseEntity<?> agregarHojaVida(@RequestBody HojaVida hojavida) {
        serviceHojaVida.save(hojavida);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

//    @PutMapping("/update_hojavida/{id}")
//    public ResponseEntity<?> updateHojaVida(@PathVariable(value = "id") Long id, @RequestBody HojaVida hojavida) {
    @PutMapping(path = "/update_hojavida/{id}", consumes = {"application/json; charset=utf-8"})
    public ResponseEntity<?> updateHojaVida(@PathVariable(value = "id") Long id, @RequestBody @Valid HojaVida hojavida) throws ParseException {
        HojaVida hojavidaDb = null;

        HojaVidaDto hojaVidaDto = serviceHojaVida.findById(id);

        hojavidaDb = mapper.map(hojaVidaDto, HojaVida.class);
        if (hojavidaDb != null) {

            hojavidaDb.setObjetivo(hojavida.getObjetivo());
            hojavidaDb.setSalario(hojavida.getSalario());
            hojavidaDb.setTipoPostulante(hojavida.getTipoPostulante());
            //hojavidaDb.setPersona(hojavida.getPersona());

            hojaVidaDto = serviceHojaVida.uptadeHojaVida(hojavidaDb);

            return new ResponseEntity<>(hojaVidaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        // return new ResponseEntity<>(hojavida, HttpStatus.OK);
    }

    @GetMapping("/find_persona_idHoja/{id}")
    public ResponseEntity<?> findPersonaId(@PathVariable("id") Long id) {
        HojaVidaDto hojaDb = serviceHojaVida.findHojaVidaPersonaId(id);

        if (hojaDb != null) {
            return new ResponseEntity<>(hojaDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @GetMapping("/oficioHoja")
    public ResponseEntity<?> listaOficioHoja() {
        List<OficioHoja> listaHojaVida = serviceHojaVida.findOficioHojaAll();
        System.out.println(serviceHojaVida.findAll());
        if (listaHojaVida != null) {
            if (listaHojaVida.size() != 0) {
                return new ResponseEntity<>(listaHojaVida, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    private OficioDto getOficio(Integer id)
    {
        return oficioService.findById(id);
    }
            
    @GetMapping("/find_persona_oficioHoja/{id}")
    public ResponseEntity<?> findOficioHojaPersonaId(@PathVariable("id") Long id) {
        List<OficioHojaDto> hojaDb = serviceHojaVida.findOficioHojaPersonaId(id);
        
        
     
      
        if (hojaDb != null) {
            return new ResponseEntity<>(hojaDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    //@PostMapping("/crear_oficiohoja/{idh}/crear_oficiohoja/{ido}")>>@PathVariable("idh") Long idh,@PathVariable("ido") Integer ido,@RequestBody OficioHojaDto oficioHojaDto)
    @PostMapping("/crear_oficiohoja")
    public ResponseEntity<?> agregarOficioHoja(@RequestBody OficioHoja oficioHoja) {
//         OficioHoja oficioHojaDb = new OficioHoja();
//         oficioHojaDb = mapper.map(oficioHojaDto, OficioHoja.class);
        
        serviceHojaVida.saveOficioHoja(oficioHoja);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("delete_oficiohoja")
    public ResponseEntity<Void> deleteOficioHoja(@RequestBody OficioHoja oficioHoja) {
        if (oficioHoja != null) {
            serviceHojaVida.deleteOficioHoja(oficioHoja);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
