/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Estante.
 *
 * @author Programacion Avanzada.
 */
public final class Estante {

    /**
     * La Letra.
     */
    private final String letra;

    /**
     * Los libros.
     */
    private final List<Libro> libros;

    /**
     * The Constructor.
     *
     * @param letra del estante.
     */
    public Estante(String letra) {
        this.letra = letra;
        this.libros = new ArrayList<>();
    }

    /**
     * Retorna la letra de este estante.
     *
     * @return the Letra.
     */
    public String getLetra() {
        return this.letra;
    }

    /**
     * Retorna el numero de libros.
     *
     * @return the integer.
     */
    public int getNumeroLibros() {
        return this.libros.size();
    }

    /**
     * Agregar un Libro al Estante.
     *
     * @param libro a agregar.
     */
    public void agregarLibro(Libro libro) {
        // nullity
        if (libro == null) {
            throw new IllegalArgumentException("Libro null");
        }

        // si el titulo del libro no comienza con letra -> error
        if (!libro.getTitulo().startsWith(this.letra)) {
            throw new IllegalArgumentException("Libro no pertente al Estante!");
        }

        this.libros.add(libro);
    }
}
