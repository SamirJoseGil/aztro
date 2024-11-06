package nodo.aztro.Controller;

import nodo.aztro.Models.Prueba;
import nodo.aztro.Repositories.PruebaRepository;
import nodo.aztro.Services.PruebaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prueba")
@CrossOrigin(origins = "*")
public class PruebaController {

    @Autowired
    private PruebaRepository _pruebaRepository;

    // Metodos
    @GetMapping("/index")
    public ResponseEntity<List<Prueba>> index() {
        List<Prueba> personas = new PruebaService(_pruebaRepository).index();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    // Crear
    @PostMapping("/create")
    public ResponseEntity<Prueba> create(@RequestBody Prueba prueba) {
        Prueba personaCreada = new PruebaService(_pruebaRepository).crear(prueba);
        return new ResponseEntity<>(personaCreada, HttpStatus.OK);
    }

    // Actualizar
    @PutMapping("/update/{id}")
    public ResponseEntity<Prueba> update(@PathVariable int id, @RequestBody Prueba prueba) {
        Prueba personaActualizada = new PruebaService(_pruebaRepository).update(id, prueba);
        return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
    }

    // Eliminar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Prueba> delete(@PathVariable int id) {
        Prueba personaEliminada = new PruebaService(_pruebaRepository).delete(id);
        return new ResponseEntity<>(personaEliminada, HttpStatus.OK);
    }

    // Buscar por
    @GetMapping("/findById/{id}")
    public ResponseEntity<List<Prueba>> findById(@PathVariable int id) {
        List<Prueba> prueba = new PruebaService(_pruebaRepository).findById(id);
        return new ResponseEntity<>(prueba, HttpStatus.OK);
    }

    @GetMapping("/findByNombre/{nombre}")
    public ResponseEntity<List<Prueba>> findByNombre(@PathVariable String nombre) {
        List<Prueba> prueba = new PruebaService(_pruebaRepository).findByNombre(nombre);
        return new ResponseEntity<>(prueba, HttpStatus.OK);
    }

    @GetMapping("/findByApellido/{apellido}")
    public ResponseEntity<List<Prueba>> findByApellido(@PathVariable String apellido) {
        List<Prueba> prueba = new PruebaService(_pruebaRepository).findByApellido(apellido);
        return new ResponseEntity<>(prueba, HttpStatus.OK);
    }

    @GetMapping("/findByEdad/{edad}")
    public ResponseEntity<List<Prueba>> findByEdad(@PathVariable int edad) {
        List<Prueba> prueba = new PruebaService(_pruebaRepository).findByEdad(edad);
        return new ResponseEntity<>(prueba, HttpStatus.OK);
    }

    @GetMapping("/findByCorreo/{correo}")
    public ResponseEntity<List<Prueba>> findByCorreo(@PathVariable String correo) {
        List<Prueba> prueba = new PruebaService(_pruebaRepository).findByCorreo(correo);
        return new ResponseEntity<>(prueba, HttpStatus.OK);
    }

    @GetMapping("/findByFechaNacimiento")
    public ResponseEntity<List<Prueba>> findByFechaNacimiento(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        List<Prueba> prueba = new PruebaService(_pruebaRepository).findByFechaNacimiento(fechaInicio, fechaFin);
        return new ResponseEntity<>(prueba, HttpStatus.OK);
    }

}