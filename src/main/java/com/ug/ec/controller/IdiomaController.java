
package com.ug.ec.controller;
import com.google.gson.Gson;
import com.ug.ec.domain.Idioma;
import com.ug.ec.dto.IdiomaDto;
import com.ug.ec.servicio.IIdiomaService;
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
public class IdiomaController {
      // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IIdiomaService serviceIdioma;
    
    @Autowired
    ModelMapper mapper;


    @GetMapping("/idioma")
    public ResponseEntity<?> listaIdioma() {
        // var pais=paisDao.findAll();//paisService.listarPais();
        List<IdiomaDto> listaIdiomaDto = serviceIdioma.findAll();
        if (listaIdiomaDto != null) {
            if (listaIdiomaDto.size() != 0) {
                return new ResponseEntity<>(listaIdiomaDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear_idioma")
	public ResponseEntity<?> agregarIdioma(@RequestBody Idioma idioma){
            serviceIdioma.save(idioma); 
            return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

   

    @PutMapping("/update_idioma/{id}")
    public ResponseEntity<?> updateIdioma(@PathVariable(value = "id") Integer id, @RequestBody Idioma idioma) {
        Idioma idiomaDb = null;
        IdiomaDto idiomaDto = serviceIdioma.findById(id);
        
        idiomaDb = mapper.map(idiomaDto, Idioma.class);
        if (idiomaDb != null) {
            idiomaDb.setNombreIdioma(idioma.getNombreIdioma());
            idiomaDb.setNivelIdioma(idioma.getNivelIdioma());
            
            idiomaDto = serviceIdioma.uptadeIdioma(idiomaDb);
            return new ResponseEntity<>(idiomaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    
}
