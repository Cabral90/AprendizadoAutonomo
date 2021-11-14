package com.cursojava2.curso2.models;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "Usuario")
public class Usuario {


    // Libreria lambok = para hacer a notaciones, e vita los geter y setter
    // y has como una copia de la base dato a la classe en referencia (Espejo tabla y class)
    @Id
    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY) // caso de id automatico
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "password")
    private String password;

}
