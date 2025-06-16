package com.unir.biblioteca.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Entity
@Table(name = "libros")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroEntity {
    @Column(name = "libro_id", nullable = false)    
    private Integer libroId;
    @Id    
    @Column(name = "libro_ISBN", nullable = false, length = 45)
    private String libroISBN;
    @Column(name = "libro_titulo", nullable = false, length = 200)
    private String libroTitulo;
    @Column(name = "libro_autores", nullable = false, length = 200)
    private String libroAutores;
    @Column(name = "libro_ejemplares", nullable = false)
    private Integer libroEjemplares;
    @Column(name = "libro_publicacion", nullable = false)
    private Date libroPublicacion;
    @Column(name = "libro_editorial", nullable = false, length = 60)
    private String libroEditorial;
}
