package com.unir.biblioteca.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unir.biblioteca.entity.UsuarioEntity;
import com.unir.biblioteca.repository.UsuarioRepository;
import com.unir.biblioteca.repository.UsuarioRepositoryCRUD;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioRepositoryCRUD usuarioRepositoryCRUD;

    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }
    
    public Optional<List<UsuarioEntity>> findByUsuarioCedula(String usuarioCedula) {
        return usuarioRepository.findByUsuarioCedula(usuarioCedula);
    }
    
    public Optional<List<UsuarioEntity>> findByUsuarioNombre(String usuarioNombre) {
        return usuarioRepository.findByUsuarioNombre(usuarioNombre);
    }
    
    public UsuarioEntity save(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }
    
    public  boolean deleteUsuario(String usuarioCedula){
        return findByUsuarioCedula(usuarioCedula).map(UsuarioEntity -> {
            usuarioRepositoryCRUD.deleteById(usuarioCedula);
            return true;
        }).orElse(false);
    }
}
