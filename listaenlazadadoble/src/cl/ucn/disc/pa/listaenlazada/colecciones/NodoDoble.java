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
public final class NodoDoble {

    /**
     * The Elemento.
     */
    private final Elemento elemento;

    /**
     * The anterior.
     */
    private NodoDoble anterior;

    /**
     * The siguiente.
     */
    private NodoDoble siguiente;

    /**
     * The Constructor.
     *
     * @param elemento to set.
     */
    public NodoDoble(Elemento elemento) {
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
    public NodoDoble getSiguiente() {
        return this.siguiente;
    }

    /**
     * @param siguiente the siguiente to set.
     */
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the Anterior.
     */
    public NodoDoble getAnterior() {
        return this.anterior;
    }

    /**
     * @param anterior the anterior to set.
     */
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

}
