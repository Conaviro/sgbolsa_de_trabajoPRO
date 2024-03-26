
package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.SubArea;
import com.ug.ec.dto.SubAreaDto;
import com.ug.ec.servicio.ISubAreaService;
import java.util.List;
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
public class SubAreaController {
      // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private ISubAreaService serviceSubArea;

    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;
    
    @GetMapping("/subarea")
    public ResponseEntity<?> listaSubArea() {
        // var pais=paisDao.findAll();//paisService.listarPais();
        List<SubAreaDto> subAreaDto = serviceSubArea.findAll();
        if (subAreaDto != null) {
            if (subAreaDto.size() != 0) {
                return new ResponseEntity<>(subAreaDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_subarea")
	public ResponseEntity<?> agregarSubArea(@RequestBody SubArea subarea){
		serviceSubArea.save(subarea); 
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

   

    @PutMapping("/update_subarea/{id}")
    public ResponseEntity<?> updateSubArea(@PathVariable(value = "id") Integer id, @RequestBody SubArea subarea) {
        SubArea subareaDb = null;
        
        //subareaDb = serviceSubArea.findById(id);
        SubAreaDto subAreaDto = serviceSubArea.findById(id);
        subareaDb = mapper.map(subAreaDto, SubArea.class);
        
        if (subareaDb != null) {
            subareaDb.setNombreSubArea(subarea.getNombreSubArea());
            
            subAreaDto = serviceSubArea.uptadeSubArea(subareaDb);
            return new ResponseEntity<>(subAreaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    
}
