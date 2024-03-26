package com.ug.ec.controller;

import com.google.gson.Gson;
import com.ug.ec.domain.Empresa;
import com.ug.ec.dto.EmpresaDto;
import com.ug.ec.servicio.IEmpresaService;
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
public class EmpresaController {

    // Inyectamos una instancia desde nuestro ApplicationContext   
    @Autowired
    private IEmpresaService serviceEmpresa;
    
    @Autowired
    ModelMapper mapper;
    
    @Autowired
    Gson gson;

    @GetMapping("/empresa")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listaEmpresa() {
        
        
        List<EmpresaDto> empresaDto = serviceEmpresa.findAll();
        if (empresaDto != null) {
            if (empresaDto.size() != 0) {
                return new ResponseEntity<>(empresaDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/crear_empresa")
    public ResponseEntity<?> agregarEmpresa(@RequestBody Empresa empresa) {
        serviceEmpresa.save(empresa);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update_empresa/{id}")
    public ResponseEntity<?> updateEmpresa(@PathVariable(value = "id") Integer id, @RequestBody Empresa empresa) {
        Empresa empresaDb = null;
        
        EmpresaDto empresaDto = serviceEmpresa.findById(id);
        empresaDb = mapper.map(empresaDto, Empresa.class);
        if (empresaDb != null) {
            empresaDb.setNombreEmpresa(empresa.getNombreEmpresa());
            empresaDb.setRasonSocial(empresa.getRasonSocial());
            empresaDb.setLogo(empresa.getLogo());
            empresaDb.setPaginaWeb(empresa.getPaginaWeb());
            
            
            empresaDto = serviceEmpresa.uptadeEmpresa(empresaDb);
            
            return new ResponseEntity<>(empresaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
