package com.example.ejemplo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/personas"})
public class Controlador {

    @Autowired
    PersonasService service;

    @GetMapping
    public List<Persona> listar(){ // ok
        return service.listar();
    }

    @PostMapping //  OK //metodos de interacion GET, POST, DELETE ....
    public Persona agregar(@RequestBody Persona p){
        return service.add(p);
    }

    @GetMapping(path = {"/{id}"})
    public Persona listarporId(@PathVariable("id") int id){
        return service.listarId(id);
    }

    @PutMapping(path = {"/{id}"}) // ok
    public Persona editar(@RequestBody Persona p, @PathVariable("id") int id){
        p.setId(id);
        return service.edit(p);
    }

    @DeleteMapping(path = {"/{id}"})
    public Persona borrarPersona(@PathVariable("id") int id){
        return service.delete(id);
    }
}
