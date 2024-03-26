package com.ug.ec.controller;

import com.ug.ec.domain.Grupo;
import com.ug.ec.dto.GrupoDto;
import com.ug.ec.model.requests.GrupoRequestModel;
import com.ug.ec.model.responses.GrupoResponsesModel;
import com.ug.ec.servicio.IGrupoService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class GrupoController {
    // Inyectamos una instancia desde nuestro ApplicationContext   

    @Autowired
    private IGrupoService serviceGrupo;

    @Autowired
    ModelMapper mapper;

  
    @GetMapping(value = "/grupo", produces = "application/json")
    public ResponseEntity<?> listaGrupo() {
        
        
         List<GrupoResponsesModel> grupoReturn = new ArrayList<>();
        
        List<GrupoDto> listaGrupo = serviceGrupo.findAll();
        if (listaGrupo != null) {
            if (listaGrupo.size() != 0) {
                                
                 for (GrupoDto grupoDto : listaGrupo) {
                    GrupoResponsesModel comuntRest = mapper.map(grupoDto, GrupoResponsesModel.class);
                    grupoReturn.add(comuntRest);
                }

                return new ResponseEntity<>(grupoReturn, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_grupo")
    public ResponseEntity<?> agregarGrupo(@RequestBody @Valid GrupoRequestModel grupo) {

        GrupoResponsesModel grupoReturn;
        GrupoDto grupoDto = mapper.map(grupo, GrupoDto.class);
        grupoDto = serviceGrupo.save(grupoDto);

        if (grupoDto != null) {
            grupoReturn = mapper.map(grupoDto, GrupoResponsesModel.class);

            return new ResponseEntity<>(grupoReturn, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update_grupo/{id}")
    public ResponseEntity<?> updateGrupo(@PathVariable(value = "id") Integer id, @RequestBody @Valid GrupoRequestModel grupo) {
        GrupoDto grupoDb = null;
        GrupoResponsesModel grupoReturn;

        grupoDb = serviceGrupo.findById(id);
        if (grupoDb != null) {
            grupoDb.setNombreGrupo(grupo.getNombreGrupo());

            Grupo grupoEnty = mapper.map(grupoDb, Grupo.class);

            grupoDb = serviceGrupo.uptadeGrupo(grupoEnty);

            grupoReturn = mapper.map(grupoDb, GrupoResponsesModel.class);

            return new ResponseEntity<>(grupoReturn, HttpStatus.OK);

        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletegrupo/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable(value = "id") Integer id) {
        if (serviceGrupo.findById(id) != null) {
            serviceGrupo.deleteGrupo(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }

}