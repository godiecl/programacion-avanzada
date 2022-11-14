/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.biblioteca.model;

/**
 * Interface Biblioteca.
 *
 * @author Programacion Avanzada.
 */
public interface Biblioteca {

    /**
     * Agrega un libro a la biblioteca.
     *
     * @param libro a agregar.
     */
    void agregarLibro(Libro libro);

    /**
     * Cambia el estado del libro identificado por el isbn bajo prestamo.
     *
     * @param isbn del libro a prestar.
     */
    void prestarLibro(String isbn);

    /**
     * Cambia es estado del Libro identificado por el isbn disponible para prestamo.
     *
     * @param isbn del libro a prestar.
     */
    void devolverLibro(String isbn);

}
