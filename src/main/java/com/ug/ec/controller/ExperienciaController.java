
package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.Experiencia;
import com.ug.ec.dto.ExperienciaDto;
//import com.ug.ec.model.requests.ExperienciaRequestModel;
//import com.ug.ec.model.responses.ExperienciaResponsesModel;
import com.ug.ec.servicio.IExperienciaService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class ExperienciaController {
    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IExperienciaService serviceExperiencia;
    
    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    @GetMapping("/experiencia")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaExperiencia() {
        // var pais=paisDao.findAll();//paisService.listarPais();
        List<ExperienciaDto> experienciaDto = serviceExperiencia.findAll();

        if (experienciaDto != null) {
            if (experienciaDto.size() != 0) {
                return new ResponseEntity<>(experienciaDto, HttpStatus.OK);
            } else {
               return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
               return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_experiencia")
	public ResponseEntity<?> agregarExperiencia(@RequestBody @Valid Experiencia experiencia){
               
		serviceExperiencia.save(experiencia); 
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

   

    @PutMapping("/update_experiencia/{id}")
    public ResponseEntity<?> updateExperiencia(@PathVariable(value = "id") Integer id, @RequestBody Experiencia experiencia) {
        Experiencia experienciaDb = null;
        ExperienciaDto experienciaDto= serviceExperiencia.findById(id);
        experienciaDb = mapper.map (experienciaDto, Experiencia.class);
        if (experienciaDb != null) {
            experienciaDb.setDescripcion(experiencia.getDescripcion());
            experienciaDb.setTiempoExperiencia(experiencia.getTiempoExperiencia());

            experienciaDto= serviceExperiencia.uptadeExperiencia(experienciaDb);

            return new ResponseEntity<>(experienciaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }    
}
