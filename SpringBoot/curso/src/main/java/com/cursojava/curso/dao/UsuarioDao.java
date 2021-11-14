package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();
    //boolean editarUsuario(Long id);
    //boolean eliminarUsuario(Long id);

}
