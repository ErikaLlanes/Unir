package com.unir.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.biblioteca.entity.LibroEntity;
@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, String>{

    Optional<List<LibroEntity>> findByLibroISBN(String libroISBN); 

    Optional<List<LibroEntity>> findByLibroTitulo(String libroTitulo);

    Optional<List<LibroEntity>>findByLibroAutores(String libroAutores);        
      
}



