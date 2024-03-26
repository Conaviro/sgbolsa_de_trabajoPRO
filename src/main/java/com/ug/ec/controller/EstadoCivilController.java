package com.ug.ec.controller;

import com.ug.ec.domain.EstadoCivil;
import com.ug.ec.dto.EstadoCivilDto;
import com.ug.ec.model.requests.EstadoCivilRequestModel;
import com.ug.ec.model.responses.EstadoCivilResponsesModel;
import com.ug.ec.servicio.IEstadoCivilService;
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
public class EstadoCivilController {
    // Inyectamos una instancia desde nuestro ApplicationContext   

    @Autowired
    private IEstadoCivilService serviceEstadoCivil;
    
    @Autowired
    ModelMapper mapper;

    @GetMapping("/estadocivil")
    public ResponseEntity<?> listaEstadoCivil() {
      
       List<EstadoCivilDto> estadoCivilDto = serviceEstadoCivil.findAll();
        
        if (estadoCivilDto != null) {
            if (estadoCivilDto.size() != 0) {
                return new ResponseEntity<>(estadoCivilDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
       /* 
        List<EstadoCivilResponsesModel> estadoCivilReturn = new ArrayList<>();

        List<EstadoCivilDto> listaEstadoCivildto = serviceEstadoCivil.findAll();
        if (listaEstadoCivildto != null) {
            if (listaEstadoCivildto.size() != 0) {
                               
                 for (EstadoCivilDto estadoCivilDto : listaEstadoCivildto) {
                    EstadoCivilResponsesModel comuntRest = mapper.map(estadoCivilDto, EstadoCivilResponsesModel.class);
                    estadoCivilReturn.add(comuntRest);
                }
                
                return new ResponseEntity<>(estadoCivilReturn, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }*/

    }

    @PostMapping("/crear_estadocivil")
    public ResponseEntity<?> agregarEstadoCivil(@RequestBody @Valid EstadoCivilRequestModel estadocivil) {
         EstadoCivilResponsesModel estadoCivilReturn;
         EstadoCivilDto estadoCivilDto = mapper.map(estadocivil, EstadoCivilDto.class);
        estadoCivilDto=serviceEstadoCivil.save(estadoCivilDto);
        
        if (estadoCivilDto != null) {
            estadoCivilReturn = mapper.map(estadoCivilDto, EstadoCivilResponsesModel.class);

            return new ResponseEntity<>(estadoCivilReturn, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        
       
    }

    @PutMapping("/update_estadocivil/{id}")
    public ResponseEntity<?> updateEstadoCivil(@PathVariable(value = "id") Integer id, @RequestBody @Valid EstadoCivilRequestModel estadocivil) {
        EstadoCivil estadocivilDb = null;  
        
        EstadoCivilDto estadocivilDto = serviceEstadoCivil.findById(id);

        
        //EstadoCivilResponsesModel estadocivilReturn;
        
        estadocivilDb = mapper.map(estadocivilDto,EstadoCivil.class);
        if (estadocivilDb != null) {
            estadocivilDb.setNombreEstadoCivil(estadocivil.getNombreEstadoCivil());
            
            //EstadoCivil estadoCivilEnty = mapper.map(estadocivilDb, EstadoCivil.class); 
            
            //estadocivilDb=serviceEstadoCivil.uptadeEstadocivil(estadoCivilEnty);
            
            //estadocivilReturn = mapper.map(estadocivilDb, EstadoCivilResponsesModel.class);
            
            estadocivilDto = serviceEstadoCivil.uptadeEstadocivil(estadocivilDb);
            
            return new ResponseEntity<>(estadocivilDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
