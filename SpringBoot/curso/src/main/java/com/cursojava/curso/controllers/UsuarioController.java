package com.cursojava.curso.controllers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UsuarioController {

    @RequestMapping(value = "user/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario user = new Usuario();
        user.setId(id);
        user.setNombre("Jose");
        user.setApellido("Cabral");
        user.setEmail("cabralzay@gmail.com");
        user.setTelefono("660660660");
        user.setPassword("hola");
        return user;
    }

    @RequestMapping(value = "users")
    public List<Usuario> getUsuarios(){

        List<Usuario>  usuarios = new ArrayList<>();
        Usuario user1 = new Usuario();
        user1.setId(001L);
        user1.setNombre("Amadeu");
        user1.setApellido("Mack");
        user1.setEmail("cabralzay@gmail.com");
        user1.setTelefono("660660660");
        user1.setPassword("hola");

        Usuario user2 = new Usuario();
        user2.setId(002L);
        user2.setNombre("Jose");
        user2.setApellido("Cabral");
        user2.setEmail("cabralzay@gmail.com");
        user2.setTelefono("660660660");
        user2.setPassword("hola");

        Usuario user3 = new Usuario();
        user3.setId(003L);
        user3.setNombre("Mark");
        user3.setApellido("Pedrosa");
        user3.setEmail("PedrozaMac@gmail.com");
        user3.setTelefono("66466565");
        user3.setPassword("fixe");

        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        return usuarios;
    }

    @RequestMapping(value = "editar")
    public Usuario editar(){
        Usuario user = new Usuario();
        user.setNombre("Jose");
        user.setApellido("Cabral");
        user.setEmail("cabralzay@gmail.com");
        user.setTelefono("660660660");
        user.setPassword("hola");
        return user;
    }

    @RequestMapping(value = "eliminar")
    public Usuario eliminar(){
        Usuario user = new Usuario();
        user.setNombre("Jose");
        user.setApellido("Cabral");
        user.setEmail("cabralzay@gmail.com");
        user.setTelefono("660660660");
        user.setPassword("hola");
        return user;
    }

    @RequestMapping(value = "buscar")
    public Usuario buscar(){
        Usuario user = new Usuario();
        user.setNombre("Jose");
        user.setApellido("Cabral");
        user.setEmail("cabralzay@gmail.com");
        user.setTelefono("660660660");
        user.setPassword("hola");
        return user;
    }
}
