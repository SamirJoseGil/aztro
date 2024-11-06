package nodo.aztro.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nodo.aztro.Models.Prueba;

import java.time.LocalDate;
import java.util.List;

public interface PruebaRepository extends CrudRepository<Prueba, Integer> {


    // Traer Todos
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM prueba")
    List<Prueba> index();

    // Busqueda por Int
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM prueba WHERE id = :id")
    List<Prueba> findById(int id);


    // Busqueda por String
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM prueba WHERE nombre LIKE %:nombre%")
    List<Prueba> findByNombre(String nombre);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM prueba WHERE apellido LIKE %:apellido%")
    List<Prueba> findByApellido(String apellido);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM prueba WHERE edad = :edad")
    List<Prueba> findByEdad(int edad);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM prueba WHERE correo LIKE %:correo%")
    List<Prueba> findByCorreo(String correo);


    // Busqueda por rango
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM prueba WHERE fecha_nacimiento BETWEEN :fechaInicio AND :fechaFin")
    List<Prueba> findByFechaNacimiento(LocalDate fechaInicio, LocalDate fechaFin);


    // Crear y Actualizar
    Prueba saveAndFlush(Prueba prueba);
}
