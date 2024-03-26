package com.ug.ec.controller;

import com.ug.ec.domain.Genero;
import com.ug.ec.dto.GeneroDto;
import com.ug.ec.model.requests.GeneroRequestModel;
import com.ug.ec.model.responses.GeneroResponsesModel;
import com.ug.ec.servicio.IGeneroService;
import java.util.ArrayList;
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
public class GeneroController {

    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IGeneroService serviceGenero;

    @Autowired
    ModelMapper mapper;
    
    @GetMapping("/genero")
    public ResponseEntity<?> listaGenero() {
        
         
        
        List<GeneroResponsesModel> generoReturn = new ArrayList<>();
        
        List<GeneroDto> listaGenero = serviceGenero.findAll();
        if (listaGenero != null) {
            if (listaGenero.size() != 0) {
                
                
                for (GeneroDto generoDto : listaGenero) {
                    GeneroResponsesModel objRest = mapper.map(generoDto, GeneroResponsesModel.class);
                    generoReturn.add(objRest);
                }
                
                return new ResponseEntity<>(generoReturn, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_genero")
    public ResponseEntity<?> agregarGenero(@RequestBody @Valid GeneroRequestModel  genero) {
        GeneroResponsesModel  generoReturn;
        
         GeneroDto generoDto = mapper.map(genero, GeneroDto.class);
        generoDto=serviceGenero.save(generoDto);
        
        if (generoDto != null) {
            generoReturn = mapper.map(generoDto, GeneroResponsesModel.class);

            return new ResponseEntity<>(generoReturn, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        
    }

    @PutMapping("/update_genero/{id}")
    public ResponseEntity<?> updateGenero(@PathVariable(value = "id") Integer id, @RequestBody @Valid GeneroRequestModel genero) {
        GeneroDto generoDb = null;
        GeneroResponsesModel  generoReturn;
        generoDb = serviceGenero.findById(id);
        if (generoDb != null) {
            generoDb.setNombreGenero(genero.getNombreGenero());
            
            Genero generoEnty  = mapper.map(generoDb,Genero.class);            
            generoDb=serviceGenero.uptadeGenero(generoEnty);
            generoReturn=mapper.map(generoDb,GeneroResponsesModel.class);
            
            return new ResponseEntity<>(generoReturn, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}