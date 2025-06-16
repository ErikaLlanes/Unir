package com.unir.biblioteca.controller;
import com.unir.biblioteca.entity.LibroEntity;
import com.unir.biblioteca.service.LibroService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LibroController {
    @Autowired
    private LibroService libroService;
    
    @GetMapping({"/libros/all"})
    public ResponseEntity<List<LibroEntity>> getAll(){
    return new  ResponseEntity<>(libroService.findAll(),HttpStatus.OK);
    }
   
    @GetMapping("/libros/isbn/{libroISBN}")
    public ResponseEntity<List<LibroEntity>> getLibrosByISBN(@PathVariable("libroISBN") String libroISBN) {
        if(libroService.findByLibroISBN(libroISBN).get().isEmpty()){
            return new ResponseEntity<>(HttpStatus.valueOf(204));
        }else{
            return new ResponseEntity<>(libroService.findByLibroISBN(libroISBN).get(),HttpStatus.valueOf(200));
        }
    }

    @GetMapping("/libros/isbnrequired/")
    public Optional<List<LibroEntity>> getLibrosByISBNParam(@RequestParam(name= "libroISBN") String libroISBN) {
        return libroService.findByLibroISBN(libroISBN);
    }

    @GetMapping("/libros/titulo/{titulo}")
    public Optional<List<LibroEntity>> getLibrosByTitulo(@PathVariable(name = "titulo") String libroTitulo) {
        return libroService.findByLibroTitulo(libroTitulo);
    }

    @GetMapping("/libros/autor/{autor}")
    public Optional<List<LibroEntity>> getLibrosByAutor(@PathVariable(name = "autor") String libroAutor) {
        return libroService.findByLibroAutores(libroAutor);
    }
   
    @PostMapping(value = "/libros/save", consumes = "application/json;charset=UTF-8")    
    public  ResponseEntity<LibroEntity> save(@RequestBody LibroEntity libroEntity){
        return new ResponseEntity<LibroEntity>(libroService.save(libroEntity),HttpStatus.CREATED);
    }

    @DeleteMapping("/libros/delete/{libroISBN}")
    public ResponseEntity deleteById(@PathVariable(name="libroISBN") String libroISBN){
        if(libroService.deleteLibro(libroISBN)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/libros/update/{libroISBN}")    
    public  ResponseEntity <LibroEntity> update(@RequestBody LibroEntity libroEntity, @PathVariable(name="libroISBN") String libroISBN){
        LibroEntity libro = new LibroEntity();
        libro=libroEntity;
        libro.setLibroISBN(libroISBN);    
        return new ResponseEntity<>(libroService.save(libroEntity),HttpStatus.OK);
    }

}
