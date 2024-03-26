package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.TipoIdentificacion;
import com.ug.ec.dto.TipoIdentificacionDto;
import com.ug.ec.model.requests.TipoIdentificacionRequestModel;
import com.ug.ec.model.responses.TipoIdentificacionResponsesModel;
import com.ug.ec.servicio.ITipoIdentificacionService;
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
public class TipoIdentificacionController {
    // Inyectamos una instancia desde nuestro ApplicationContext   

    @Autowired
    private ITipoIdentificacionService serviceTipoIdentificacion;

    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    @GetMapping("/tipoidentificacion")
    public ResponseEntity<?> listaTipoIdentificacion() {

         
        
        List<TipoIdentificacionDto> tipoIdentificacionDto = serviceTipoIdentificacion.findAll();

        if (tipoIdentificacionDto != null) {
            if (tipoIdentificacionDto.size() != 0) {                
                return new ResponseEntity<>(tipoIdentificacionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_tipoidentificacion")
    public ResponseEntity<?> agregarTipoIdentificacion(@RequestBody @Valid TipoIdentificacionRequestModel tipoidentificacion) {

        TipoIdentificacionResponsesModel tipoIdentificacionReturn;
        TipoIdentificacionDto tipoIdentificacionDto = mapper.map(tipoidentificacion, TipoIdentificacionDto.class);
        tipoIdentificacionDto = serviceTipoIdentificacion.save(tipoIdentificacionDto);

        if (tipoIdentificacionDto != null) {
            tipoIdentificacionReturn = mapper.map(tipoIdentificacionDto, TipoIdentificacionResponsesModel.class);

            return new ResponseEntity<>(tipoIdentificacionReturn, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update_tipoidentificacion/{id}")
    public ResponseEntity<?> updateTipoIdentificacion(@PathVariable(value = "id") Integer id, @RequestBody  @Valid TipoIdentificacionRequestModel tipoidentificacion) {
        TipoIdentificacion tipoidentificacionDb = null;
        
        //TipoIdentificacionResponsesModel tipoIdentificacionReturn;
        TipoIdentificacionDto tipoIdentificacionDto = serviceTipoIdentificacion.findById(id);
        tipoidentificacionDb = mapper.map(tipoIdentificacionDto, TipoIdentificacion.class);
        
        if (tipoidentificacionDb != null) {
            
            tipoidentificacionDb.setNombreTipoIdentificacion(tipoidentificacion.getNombreTipoIdentificacion());
            //TipoIdentificacion tipoIdentificacionEnty = mapper.map(tipoidentificacionDb, TipoIdentificacion.class);
            
            tipoIdentificacionDto = serviceTipoIdentificacion.uptadeTipoIdentificacion(tipoidentificacionDb);
            
            //tipoIdentificacionReturn= mapper.map(tipoidentificacionDb, TipoIdentificacionResponsesModel.class);
            
            return new ResponseEntity<>(tipoIdentificacionDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
