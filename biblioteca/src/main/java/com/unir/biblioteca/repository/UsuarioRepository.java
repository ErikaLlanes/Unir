package com.unir.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unir.biblioteca.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {
    
    Optional<List<UsuarioEntity>> findByUsuarioCedula(String usuarioCedula);
    
    Optional<List<UsuarioEntity>> findByUsuarioNombre(String usuarioNombre);
    
    Optional<List<UsuarioEntity>> findByUsuarioCelular(String usuarioCelular);
}
