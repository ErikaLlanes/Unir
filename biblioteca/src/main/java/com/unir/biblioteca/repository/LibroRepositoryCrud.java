package com.unir.biblioteca.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.unir.biblioteca.entity.LibroEntity;

@Repository
public interface LibroRepositoryCrud extends CrudRepository<LibroEntity, String>{
            
} 
