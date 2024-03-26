package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.Contacto;
import com.ug.ec.dto.ContactoDto;
import com.ug.ec.servicio.IContactoService;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequestMapping("/bolsatrabajo")
public class ContactoController {
    
    @Autowired
    private IContactoService serviceContacto;
    
    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    @GetMapping("/contacto")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaContacto() {
        
        List<ContactoDto> contactoDto = serviceContacto.findAll();
        
        if (contactoDto != null) {
            if (contactoDto.size() != 0) {
                return new ResponseEntity<>(contactoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_contacto")
    public ResponseEntity<?> agregarContacto(@RequestBody Contacto contacto) {
        serviceContacto.save(contacto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_contacto/{id}")
    public ResponseEntity<?> updateContacto(@PathVariable(value = "id") Integer id, @RequestBody Contacto contacto) {
        Contacto contactoDb = null;
        
        ContactoDto contactoDto = serviceContacto.findById(id);
        
        contactoDb = mapper.map(contactoDto, Contacto.class);
        if (contactoDb != null) {
//            contactoDb.setIdEmpresa(contacto.getIdEmpresa());
//            contactoDb.setIdPersona(contacto.getIdPersona());
//            contactoDto = serviceContacto.uptadeContacto(contactoDb);

            contactoDto = serviceContacto.uptadeContacto(contactoDb);
            return new ResponseEntity<>(contactoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
