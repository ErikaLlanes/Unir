package com.unir.biblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="usuarios")
@Getter
@Setter
@NoArgsConstructor
public class UsuarioEntity {    
    @Id
    @Column(name="usuario_cedula",nullable = false, length = 12)
    private String usuarioCedula;
    @Column(name="usuario_nombre",nullable = false, length = 60)    
    private String usuarioNombre;
    @Column(name="usuario_apellido",nullable = false, length = 60)
    private String usuarioApellido;
    @Column(name="usuario=celular",nullable = true, length = 12)
    private String usuarioCelular;
    @Column(name="usuario_direccion",nullable = false, length = 120)
    private String usuarioDireccion;

   
   
}
