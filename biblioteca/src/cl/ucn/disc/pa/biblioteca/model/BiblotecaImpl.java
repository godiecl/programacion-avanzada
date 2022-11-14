/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.biblioteca.model;

import java.util.LinkedList;
import java.util.List;

/**
 * The implementacion de Biblioteca.
 *
 * @author Programacion Avanzada.
 */
public final class BiblotecaImpl implements Biblioteca {

    /**
     * Los estantes.
     */
    private final List<Estante> estantes;

    /**
     * La Biblioteca.
     */
    public BiblotecaImpl() {
        // Creacion de la lista de estantes
        this.estantes = new LinkedList<>();

        // Creacion de los estantes
        for (char c = 'A'; c <= 'Z'; c++) {
            this.estantes.add(new Estante(Character.toString(c)));
        }
    }

    /**
     * Agrega un libro a la biblioteca.
     *
     * @param libro a agregar.
     */
    @Override
    public void agregarLibro(Libro libro) {
        // ciclo de busqueda para insertar el libro
        for (Estante estante : this.estantes) {
            if (libro.getTitulo().startsWith(estante.getLetra())) {
                estante.agregarLibro(libro);
                return;
            }
        }
        throw new IllegalArgumentException("Letra no encontrada!");
    }
}
