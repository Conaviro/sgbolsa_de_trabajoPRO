package com.ug.ec.controller;

import com.ug.ec.domain.Oferta;
import com.ug.ec.dto.OfertaDto;
import com.ug.ec.servicio.IOfertaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
public class OfertaController {
    
    // Inyectamos una instancia desde nuestro ApplicationContext   
    
    
    @Autowired
    private IOfertaService serviceOferta;
    
    @Autowired
    ModelMapper mapper;
        
    @GetMapping("/oferta")
    public ResponseEntity<?> listaOferta() {
        List<OfertaDto> listaOferta = serviceOferta.findAll();
        System.out.println(serviceOferta.findAll());
        if (listaOferta != null) {
            if (listaOferta.size() != 0) {
                return new ResponseEntity<>(listaOferta, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/crear_oferta")
    public ResponseEntity<?> agregarOferta(@RequestBody Oferta oferta) {
        serviceOferta.save(oferta);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_oferta/{id}")
    public ResponseEntity<?> updateOferta(@PathVariable(value = "id") Long id, @RequestBody Oferta oferta) {
        Oferta ofertaDb = null;
        OfertaDto ofertaDto = serviceOferta.findById(id);
        
        ofertaDb = mapper.map(ofertaDto, Oferta.class);

        if (ofertaDb != null) {
            
            ofertaDb.setTituloOferta(oferta.getTituloOferta());
            ofertaDb.setFechaPublicacion(oferta.getFechaPublicacion());
            
            ofertaDb.setTipoEmpleo(oferta.getTipoEmpleo());
            ofertaDb.setSalario(oferta.getSalario());
                        
            ofertaDb.setLugar(oferta.getLugar());
            ofertaDb.setDetalle(oferta.getDetalle());
            
            ofertaDto = serviceOferta.uptadeOferta(ofertaDb);
            return new ResponseEntity<>(ofertaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @GetMapping("/buscarDestacadas")
    public ResponseEntity<?> listabuscarDestacadas() {
        List<OfertaDto> listaOferta = serviceOferta.buscarDestacadas();
       // System.out.println(serviceOferta.findAll());
        if (listaOferta != null) {
            if (listaOferta.size() != 0) {
                return new ResponseEntity<>(listaOferta, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/buscarByExample")
    public ResponseEntity<?> listabuscarByExample() //@PathVariable(value = "id") Example<Oferta> example
    {
        List<OfertaDto> listaOferta = serviceOferta.buscarDestacadas();//.buscarByExample(example);// .buscarDestacadas();
       // System.out.println(serviceOferta.findAll());
        if (listaOferta != null) {
            if (listaOferta.size() != 0) {
                return new ResponseEntity<>(listaOferta, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
