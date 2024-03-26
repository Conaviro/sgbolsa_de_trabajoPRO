package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.TipoLicencia;
import com.ug.ec.dto.TipoLicenciaDto;
import com.ug.ec.model.requests.TipoLicenciaRequestModel;
import com.ug.ec.model.responses.TipoLicenciaResponsesModel;
import com.ug.ec.servicio.ITipoLicenciaService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class TipoLicenciaController {
    // Inyectamos una instancia desde nuestro ApplicationContext   

    @Autowired
    private ITipoLicenciaService serviceTipoLicencia;

    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    @GetMapping("/tipolicencia")
    public ResponseEntity<?> listaTipoLicencia() {
                 
        //List<TipoLicenciaResponsesModel> tipolicenciaReturn = new ArrayList<>();
        List<TipoLicenciaDto> tipoLicenciaDto = serviceTipoLicencia.findAll();
        
        if (tipoLicenciaDto != null) {
            if (tipoLicenciaDto.size() != 0) {
                
                /*
                 for (TipoLicenciaDto tipolinDto : listaTipoLicencia) {
                    TipoLicenciaResponsesModel objRest = mapper.map(tipolinDto, TipoLicenciaResponsesModel.class);
                    tipolicenciaReturn.add(objRest);
                }
                */
                return new ResponseEntity<>(tipoLicenciaDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_tipolicencia")
    public ResponseEntity<?> agregarTipoLicencia(@RequestBody @Valid TipoLicenciaRequestModel tipolicencia) {

        TipoLicenciaResponsesModel tipolicenciaReturn;
        TipoLicenciaDto tipolicenciaDto = mapper.map(tipolicencia, TipoLicenciaDto.class);
        tipolicenciaDto = serviceTipoLicencia.save(tipolicenciaDto);

        if (tipolicenciaDto != null) {
            tipolicenciaReturn = mapper.map(tipolicenciaDto, TipoLicenciaResponsesModel.class);

            return new ResponseEntity<>(tipolicenciaReturn, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update_tipolicencia/{id}")
    public ResponseEntity<?> updateTipoLicencia(@PathVariable(value = "id") Integer id, @RequestBody @Valid TipoLicenciaRequestModel tipolicencia) {
        TipoLicencia tipolicenciaDb = null;
        
        //TipoLicenciaResponsesModel tipolicenciaReturn;
        
        TipoLicenciaDto tipolicenciaDto = serviceTipoLicencia.findById(id);
        tipolicenciaDb = mapper.map(tipolicenciaDto, TipoLicencia.class);
        if (tipolicenciaDb != null) {
            tipolicenciaDb.setNombreTipoLicencia(tipolicencia.getNombreTipoLicencia());
            
            //TipoLicencia tipoLicenciaEnty = mapper.map(tipolicenciaDb, TipoLicencia.class); 
            
            tipolicenciaDto=serviceTipoLicencia.uptadeTipoLicencia(tipolicenciaDb);
            
            //tipolicenciaReturn = mapper.map(tipolicenciaDb, TipoLicenciaResponsesModel.class);
            
            return new ResponseEntity<>(tipolicenciaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
