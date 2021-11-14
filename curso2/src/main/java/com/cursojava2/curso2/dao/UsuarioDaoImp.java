package com.cursojava2.curso2.dao;

import com.cursojava2.curso2.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class UsuarioDaoImp implements UsuarioDao {
    @PersistenceContext
    EntityManager entityManager; // conecion db

    @Override
    public List<Usuario> getUsuarios() {

        String query = "FROM Usuario"; // consultas hibernet

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email ";  // AND password = :password // consultas hibernet

        List<Usuario> lista = entityManager.createQuery(query)
                 .setParameter("email",usuario.getEmail())
                 .getResultList();

        if(lista.isEmpty()){
            return null;
        }
        String passHash = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passHash, usuario.getPassword())){
            System.out.println("Usuario encontrado: "+ lista.get(0));
            return lista.get(0);
        }
        return null;

       /* if(list.isEmpty()){
            return false;
        }else{
            return true;
        }*/
       // return !lista.isEmpty();
    }
}
