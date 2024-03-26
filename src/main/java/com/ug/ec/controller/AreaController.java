package com.ug.ec.controller;

import com.ug.ec.domain.Area;
import com.ug.ec.servicio.IAreaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
import com.google.gson.Gson;
import com.ug.ec.dto.AreaDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class AreaController {

    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IAreaService serviceArea;
    
    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    @GetMapping("/area")
    @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<?> listaArea() {
        List<AreaDto> listaAreadto = serviceArea.findAll();
        if (listaAreadto != null) {
            if (listaAreadto.size() != 0) {
                return new ResponseEntity<>(listaAreadto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/crear_area")
    public ResponseEntity<?> agregarArea(@RequestBody Area area) {
        serviceArea.save(area);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_area/{id}")
    public ResponseEntity<?> updateArea(@PathVariable(value = "id") Integer id, @RequestBody Area area) {
        Area areaDb = null;
        AreaDto areaDto = serviceArea.findById(id);
        areaDb = mapper.map(areaDto, Area.class);
        if (areaDb != null) {
            areaDb.setNombreArea(area.getNombreArea());
           // areaDb.setSubArea(area.getSubArea());
            areaDto = serviceArea.uptadeArea(areaDb);
            return new ResponseEntity<>(areaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
