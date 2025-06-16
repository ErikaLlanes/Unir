package com.unir.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "prestamo_libro")
@Setter
@Getter
public class PrestamoLibroEntity {
    @EmbeddedId
    private PrestamoLibroEntityPK id;

    @ManyToOne
    @JoinColumn(name = "prestamo_id", insertable = false, updatable = false)
    private PrestamoEntity prestamo;

    @ManyToOne    
    @JoinColumn(name = "libro_ISBN", insertable = false, updatable = false)
    private LibroEntity libro;
}
