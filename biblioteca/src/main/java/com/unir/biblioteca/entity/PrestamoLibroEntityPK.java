package com.unir.biblioteca.entity;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class PrestamoLibroEntityPK implements Serializable {   
     @Column(name = "prestamo_id")
    private Integer prestamoId;

    @Column(name = "libro_ISBN")
    private String libroISBN;
}
