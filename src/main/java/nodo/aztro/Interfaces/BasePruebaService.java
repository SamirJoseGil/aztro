package nodo.aztro.Interfaces;

import nodo.aztro.Models.Prueba;

import java.time.LocalDate;
import java.util.List;

public interface BasePruebaService {

    // Traer Todos
    List<Prueba> index();

    // Traer por
    List<Prueba> findById(int id);
    List<Prueba> findByNombre(String nombre);
    List<Prueba> findByApellido(String apellido);
    List<Prueba> findByEdad(int edad);
    List<Prueba> findByCorreo(String correo);
    List<Prueba> findByFechaNacimiento(LocalDate fechaInicio, LocalDate fechaFin);

    // Crear
    Prueba crear(Prueba prueba);

    // Actualizar
    Prueba update(int id, Prueba prueba);

    // Eliminar
    Prueba delete(int id);

}