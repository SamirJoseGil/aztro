package nodo.aztro.Interfaces;

import java.util.List;

import nodo.aztro.Models.Libro;

public interface BaseLibroService {

    List<Libro> index();
    List<Libro> findTwoLibros (String titulo1, String titulo2);
}
