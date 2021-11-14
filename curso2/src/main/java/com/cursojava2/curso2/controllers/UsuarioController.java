package com.cursojava2.curso2.controllers;

import com.cursojava2.curso2.dao.UsuarioDao;
import com.cursojava2.curso2.models.Usuario;
import com.cursojava2.curso2.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsuarioController {

    @Autowired // hibernet con Ijeccion de dependencias
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario user = new Usuario();
        user.setId(id);
        user.setNombre("Jose");
        user.setApellido("Cabral");
        user.setEmail("cabralzay@gmail.com");
        user.setTelefono("660660660");
        user.setPassword("hola");
        return user;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {

        if (!validarToken(token)) {
            return null;
        }

        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token) {
        String idUsuario = jwtUtil.getKey(token);
        return idUsuario != null;

    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        // argon2.hash( nivel_de_seguridad, memoria, paralelismo)
        String passHash = argon2.hash(1, 1024, 1, usuario.getPassword()); // no me gusta

        //System.out.println(usuario.toString());
        usuario.setPassword(passHash);

        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/editar")
    public Usuario editar() {
        Usuario user = new Usuario();
        user.setNombre("Jose");
        user.setApellido("Cabral");
        user.setEmail("cabralzay@gmail.com");
        user.setTelefono("660660660");
        user.setPassword("hola");
        return user;
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if (!validarToken(token)) {
            return;
        }

        usuarioDao.eliminar(id);

    }


}
