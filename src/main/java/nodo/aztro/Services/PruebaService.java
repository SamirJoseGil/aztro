package nodo.aztro.Services;

import nodo.aztro.Interfaces.BasePruebaService;
import nodo.aztro.Repositories.PruebaRepository;
import nodo.aztro.Models.Prueba;

import java.time.LocalDate;
import java.util.List;

public class PruebaService implements BasePruebaService {

    private PruebaRepository _pruebaRepository;

    public PruebaService(PruebaRepository pruebaRepository) {

        _pruebaRepository = pruebaRepository;
    }

    // Traer Todos
    @Override
    public List<Prueba> index() {
        return _pruebaRepository.index();
    }

    // Crear
    @Override
    public Prueba crear(Prueba prueba) {
        return _pruebaRepository.saveAndFlush(prueba);
    }

    // Actualizar
    @Override
    public Prueba update(int id, Prueba prueba) {
        List<Prueba> pruebaList = _pruebaRepository.findById(id);
        if (pruebaList.size() > 0)
        {
            Prueba pruebaUpdate = pruebaList.get(0);

            pruebaUpdate.setNombre(prueba.getNombre());
            pruebaUpdate.setApellido(prueba.getApellido());
            pruebaUpdate.setEdad(prueba.getEdad());
            pruebaUpdate.setCorreo(prueba.getCorreo());
            pruebaUpdate.setFecha_nacimiento(prueba.getFecha_nacimiento());

            return _pruebaRepository.saveAndFlush(pruebaUpdate);
        }
        return null;
    }

    // Eliminar
    @Override
    public Prueba delete(int id) {
        List<Prueba> pruebaList = _pruebaRepository.findById(id);

        if (pruebaList.size() > 0)
        {
            Prueba pruebaDelete = pruebaList.get(0);
            _pruebaRepository.delete(pruebaDelete);
            return pruebaDelete;
        }
        return null;
    }

    // Traer por
    @Override
    public List<Prueba> findById(int id) {
        return _pruebaRepository.findById(id);
    }

    @Override
    public List<Prueba> findByNombre(String nombre) {
        return _pruebaRepository.findByNombre(nombre);
    }

    @Override
    public List<Prueba> findByApellido(String apellido) {
        return _pruebaRepository.findByApellido(apellido);
    }

    @Override
    public List<Prueba> findByEdad(int edad) {
        return _pruebaRepository.findByEdad(edad);
    }

    @Override
    public List<Prueba> findByCorreo(String correo) {
        return _pruebaRepository.findByCorreo(correo);
    }

    @Override
    public List<Prueba> findByFechaNacimiento(LocalDate fechaInicio, LocalDate fechaFin) {
        return _pruebaRepository.findByFechaNacimiento(fechaInicio, fechaFin);
    }

}
