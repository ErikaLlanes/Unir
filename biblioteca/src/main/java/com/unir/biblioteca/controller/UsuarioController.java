package com.unir.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.unir.biblioteca.entity.UsuarioEntity;
import com.unir.biblioteca.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Tag(name = "usuarios", description = "El api usuario trae toda la lista de usuarios")
    @GetMapping({ "/usuarios/all" })
    public List<UsuarioEntity> getAll() {
        return usuarioService.findAll();
    }

    @Tag(name = "usuarios/cedula", description = "El api consulta y trae un usuario por numero de cedula")
    @GetMapping("/usuarios/cedula/{usuarioCedula}")
    public Optional<List<UsuarioEntity>> getByUsuarioCedula(@PathVariable("usuarioCedula") String usuarioCedula) {
        return usuarioService.findByUsuarioCedula(usuarioCedula);
    }

    @Tag(name = "usuarios/nombre", description = "El api consulta y trae todos los usuarios que tengan  el nombre")
    @GetMapping("/usuarios/nombre/{usuarioNombre}")
    public Optional<List<UsuarioEntity>> getLibrosByTitulo(@PathVariable(name = "usuarioNombre") String usuarioNombre) {
        return usuarioService.findByUsuarioNombre(usuarioNombre);
    }

    
    @Tag(name = "usuarios/save", description = "El api almacena un usuario")
    @PostMapping(value = "/usuarios/save", consumes = "application/json;charset=UTF-8")
    public UsuarioEntity save(@RequestBody UsuarioEntity usuarioEntity) {
        return usuarioService.save(usuarioEntity);
    }

    @Tag(name = "usuarios/delete", description = "El api elimina un usuario que es buscado por numero de cedula")
    @DeleteMapping("/usuarios/delete/{usuarioCedula}")

    public boolean deleteById(@PathVariable(name = "usuarioCedula") String usuarioCedula) {
        return usuarioService.deleteUsuario(usuarioCedula);
    }

    @Tag(name = "usuarios/update", description = "El api actualiza datos de un usuario")
    @PutMapping(value = "/usuarios/update/{usuarioCedula}")    
    public  UsuarioEntity update(@RequestBody UsuarioEntity usuarioEntity, @PathVariable(name="usuarioCedula") String usuarioCedula){
        UsuarioEntity usuario = new UsuarioEntity();
        usuario=usuarioEntity;
        usuario.setUsuarioCedula(usuarioCedula);    
        return usuarioService.save(usuarioEntity);
    }
}
