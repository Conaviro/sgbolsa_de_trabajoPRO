package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.TipoVehiculo;
import com.ug.ec.dto.TipoVehiculoDto;
import com.ug.ec.model.requests.TipoVehiculoRequestModel;
import com.ug.ec.model.responses.TipoVehiculoResponsesModel;
import com.ug.ec.servicio.ITipoVehiculoService;
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
public class TipoVehiculoController {
    // Inyectamos una instancia desde nuestro ApplicationContext   

    @Autowired
    private ITipoVehiculoService serviceTipoVehiculo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;
    
    @GetMapping("/tipovehiculo")
    public ResponseEntity<?> listaTipoVehiculo() {
        
        //List<TipoVehiculoResponsesModel> tipoVehiculoReturn = new ArrayList<>();
        List<TipoVehiculoDto> tipoVehiculoDto = serviceTipoVehiculo.findAll();
        
        if (tipoVehiculoDto != null) {
            if (tipoVehiculoDto.size() != 0) {
                
                /*
                 for (TipoVehiculoDto tipovehDto : listaTipoVehiculo) {
                    TipoVehiculoResponsesModel objRest = mapper.map(tipovehDto, TipoVehiculoResponsesModel.class);
                    tipoVehiculoReturn.add(objRest);
                }
                */
                return new ResponseEntity<>(tipoVehiculoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_tipovehiculo")
    public ResponseEntity<?> agregarTipoVehiculo(@RequestBody @Valid TipoVehiculoRequestModel tipovehiculo) {

        TipoVehiculoResponsesModel tipoVehiculoReturn;
        TipoVehiculoDto tipovehiculoDto = mapper.map(tipovehiculo, TipoVehiculoDto.class);
        tipovehiculoDto = serviceTipoVehiculo.save(tipovehiculoDto);

        if (tipovehiculoDto != null) {
            tipoVehiculoReturn = mapper.map(tipovehiculoDto, TipoVehiculoResponsesModel.class);

            return new ResponseEntity<>(tipoVehiculoReturn, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update_tipovehiculo/{id}")
    public ResponseEntity<?> updateTipoVehiculo(@PathVariable(value = "id") Integer id, @RequestBody @Valid TipoVehiculoRequestModel tipovehiculo) {

        TipoVehiculo tipovehiculoDb=null;
        
        //TipoVehiculoResponsesModel tipoVehiculoReturn;
        TipoVehiculoDto tipoVehiculoDto = serviceTipoVehiculo.findById(id);
        tipovehiculoDb = mapper.map(tipoVehiculoDto, TipoVehiculo.class);
        
        if (tipovehiculoDb != null) {
            tipovehiculoDb.setNombreTipoVehiculo(tipovehiculo.getNombreTipoVehiculo());
            
            //TipoVehiculo tipoVehiculoEnty = mapper.map(tipovehiculoDb, TipoVehiculo.class); 
            
            tipoVehiculoDto=serviceTipoVehiculo.uptadeTipoVehiculo(tipovehiculoDb);
            
            //tipoVehiculoReturn = mapper.map(tipovehiculoDb, TipoVehiculoResponsesModel.class);
            
            return new ResponseEntity<>(tipoVehiculoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
