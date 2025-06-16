package com.unir.biblioteca.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.unir.biblioteca.entity.UsuarioEntity;

@Repository
public interface UsuarioRepositoryCRUD extends CrudRepository<UsuarioEntity,  String> {
    
}
