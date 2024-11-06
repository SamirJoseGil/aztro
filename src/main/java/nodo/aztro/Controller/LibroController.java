package nodo.aztro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nodo.aztro.Models.Libro;
import nodo.aztro.Repositories.LibroRepository;
import nodo.aztro.Services.LibroService;

@RestController
@RequestMapping("/libro")
@CrossOrigin(origins = "*")
public class LibroController {

    @Autowired
    private LibroRepository _libroRepository;


    // Metodos
    @GetMapping("/index")
    public ResponseEntity<List<Libro>> index() {
        List<Libro> libros = new LibroService(_libroRepository).index();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/findTwoLibros/{titulo1}/{titulo2}")
    public ResponseEntity<List<Libro>> findTwoLibros(@PathVariable String titulo1, @PathVariable String titulo2) {
        List<Libro> libros = new LibroService(_libroRepository).findTwoLibros(titulo1, titulo2);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
}
