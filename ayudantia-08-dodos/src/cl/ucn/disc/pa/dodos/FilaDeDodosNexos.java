/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.dodos;

import cl.ucn.disc.pa.dodos.model.Dodo;

/**
 * The implementacion de FilaDeDodos.
 *
 * @author Programacion Avanzada.
 */
public final class FilaDeDodosNexos implements FilaDeDodos {

    /**
     * The Primer Dodo.
     */
    private NodoDodo primero;

    /**
     * Constructor del FilaDeDodosNexos.
     */
    public FilaDeDodosNexos() {
        this.primero = null;
    }

    /**
     * Agrega un dodo al inicio de la fila.
     *
     * @param dodo el dodo a agregar.
     */
    @Override
    public void agregarAlInicio(Dodo dodo) {
        NodoDodo nuevo = new NodoDodo(dodo);
        nuevo.setSiguiente(this.primero);
        this.primero = nuevo;
    }

    /**
     * Agrega un dodo al inicio de la fila.
     *
     * @param dodo     el dodo a agregar.
     * @param posicion la posicion en la que se agregara el dodo.
     */
    @Override
    public void agregarEnPosicion(Dodo dodo, int posicion) {

        // nuevo nodo a insertar
        NodoDodo nuevo = new NodoDodo(dodo);

        // insertar: al inicio de la Fila
        if (posicion == 0) {
            this.agregarAlInicio(dodo);
            return;
        }

        // buscar la posicion donde debe ser insertado
        NodoDodo actual = this.primero;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getSiguiente();
        }
        // insercion
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);

    }

    /**
     * Elimina un dodo de la fila.
     *
     * @param dodo el dodo a eliminar.
     */
    @Override
    public void sacar(Dodo dodo) {

        // si la lista esta vacia: nada que hacer
        if (this.primero == null) {
            return;
        }

        // si el primer nodo es el que se quiere eliminar
        if (this.primero.getDodo().getNombre().equals(dodo.getNombre())) {
            this.primero = this.primero.getSiguiente();
            return;
        }

        // buscar el nodo anterior al que se quiere eliminar
        for (NodoDodo actual = this.primero; actual.getSiguiente() != null; actual = actual.getSiguiente()) {
            // Si encuentro el odo en esta posicion
            if (actual.getSiguiente().getDodo().getNombre().equals(dodo.getNombre())) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return;
            }
        }

        // No lo encontre: nada que hacer
    }

    /**
     * Clase Nodo interna (solo visible para la clase FilaDeDodosNexos).
     */
    private static class NodoDodo {

        /**
         * El dodo.
         */
        private final Dodo dodo;

        /**
         * El nodo siguiente.
         */
        private NodoDodo siguiente;

        /**
         * El constructor de un nodo.
         *
         * @param dodo el dodo.
         */
        public NodoDodo(Dodo dodo) {
            this.dodo = dodo;
        }

        /**
         * @return the Dodo.
         */
        public Dodo getDodo() {
            return this.dodo;
        }

        /**
         * @return the siguiente.
         */
        public NodoDodo getSiguiente() {
            return this.siguiente;
        }

        /**
         * set the siguiente.
         *
         * @param siguiente nodo.
         */
        public void setSiguiente(NodoDodo siguiente) {
            this.siguiente = siguiente;
        }
    }
}
