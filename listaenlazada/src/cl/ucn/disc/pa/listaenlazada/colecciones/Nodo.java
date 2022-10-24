/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listaenlazada.colecciones;

/**
 * The Nodo.
 *
 * @author Programacion Avanzada.
 */
public final class Nodo {

    /**
     * The Elemento.
     */
    private final Elemento elemento;

    /**
     * The siguiente.
     */
    private Nodo siguiente;

    /**
     * The Constructor.
     *
     * @param elemento to set.
     */
    public Nodo(Elemento elemento) {
        // verificacion de parametros
        if (elemento == null) {
            throw new IllegalArgumentException("Elemento nulo!");
        }
        this.elemento = elemento;
    }

    /**
     * @return the elemento
     */
    public Elemento getElemento() {
        return this.elemento;
    }

    /**
     * @return the siguiente.
     */
    public Nodo getSiguiente() {
        return this.siguiente;
    }

    /**
     * @param siguiente the siguiente to set.
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
