package nodo.aztro.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nodo.aztro.Models.Libro;
import nodo.aztro.Repositories.LibroRepository;
import nodo.aztro.Interfaces.BaseLibroService;

@Service
public class LibroService implements BaseLibroService {

    @Autowired
    private LibroRepository _libroRepository;

    public LibroService(LibroRepository libroRepository) {
        _libroRepository = libroRepository;
    }


    // Metodos
    @Override
    public List<Libro> index() {
        return _libroRepository.index();
    }

    @Override
    public List<Libro> findTwoLibros(String titulo1, String titulo2) {
        return _libroRepository.findTwoLibros(titulo1, titulo2);
    }
}
