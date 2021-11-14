package com.example.ejemplo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonasService{
    @Autowired
    private PersonaRespositorio  respositorio;

    @Override
    public List<Persona> listar() {
       return respositorio.findAll();

    }

    @Override
    public Persona listarId(int id) { // ok
        return respositorio.findById(id);
        //return null;
    }

    @Override
    public Persona add(Persona p) {
          return respositorio.save(p);
    }

    @Override
    public Persona edit(Persona p) {
        return respositorio.save(p);

    }

    @Override
    public Persona delete(int id) { // ok

        Persona p= respositorio.findById(id);
        if(p!=null){
            respositorio.delete(p);
        }
         return p;
    }
}
