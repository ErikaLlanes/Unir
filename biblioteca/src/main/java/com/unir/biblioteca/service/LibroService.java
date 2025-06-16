package com.unir.biblioteca.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unir.biblioteca.entity.LibroEntity;
import com.unir.biblioteca.repository.LibroRepository;
import com.unir.biblioteca.repository.LibroRepositoryCrud;

@Service    
public class LibroService {
@Autowired
private LibroRepository libroRepository;
@Autowired
private LibroRepositoryCrud libroRepositoryCRUD;


public List<LibroEntity> findAll(){
    return libroRepository.findAll();
}

public Optional<List<LibroEntity>> findByLibroISBN(String libroISBN){
    return libroRepository.findByLibroISBN(libroISBN);
}

public Optional<List<LibroEntity>> findByLibroTitulo(String libroTitulo){
    return libroRepository.findByLibroTitulo(libroTitulo);
}

public Optional<List<LibroEntity>> findByLibroAutores(String libroAutores){
    return libroRepository.findByLibroAutores(libroAutores);
}

public LibroEntity save(LibroEntity libroEntity){
    return libroRepositoryCRUD.save(libroEntity);
}

public  boolean deleteLibro(String libroISBN){
    return findByLibroISBN(libroISBN).map(LibroEntity -> {
        libroRepositoryCRUD.deleteById(libroISBN);
        return true;
    }).orElse(false);

}

}
