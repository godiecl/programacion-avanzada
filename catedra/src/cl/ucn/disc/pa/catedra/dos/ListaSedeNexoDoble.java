/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.catedra.dos;

/**
 * The Lista de Sedes basada en Nexos Dobles.
 *
 * @author Programacion Avanzada.
 */
public final class ListaSedeNexoDoble {

    /**
     * The Nodo de la Lista.
     */
    private NodoSede primero;

    /**
     * The Nodo de la Lista.
     */
    private NodoSede ultimo;

    /**
     * The Constructor.
     */
    public ListaSedeNexoDoble() {
        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Elimina una Sede de la Lista.
     *
     * @param rut de la sede a eliminar.
     */
    public void eliminar(String rut) {

        // busqueda del nodo a eliminar
        NodoSede nodoEliminar = null;
        for (NodoSede nodo = this.primero; nodo != null; nodo = nodo.getSiguiente()) {
            if (nodo.getSede().getRut().equals(rut)) {
                nodoEliminar = nodo;
                break;
            }
        }

        // No se pudo eliminar
        if (nodoEliminar == null) {
            return;
        }

        // eliminar el nodo al comienzo
        if (nodoEliminar.anterior == null) {
            this.primero = nodoEliminar.siguiente;
            return;
        }

        // eliminar el nodo al final
        if (nodoEliminar.siguiente == null) {
            this.ultimo = nodoEliminar.anterior;
            return;
        }

        // eliminar el nodo en el medio
        nodoEliminar.anterior.siguiente = nodoEliminar.siguiente;
        nodoEliminar.siguiente.anterior = nodoEliminar.anterior;

    }

    public Sede buscar(String rut) {
        throw new RuntimeException("Not implemented yet!");
    }

    public boolean agregar(Sede sede) {
        throw new RuntimeException("Not implemented yet!");
    }

    public Sede getSede(int i) {
        throw new RuntimeException("Not implemented yet!");
    }

    public int cantidadDeSedes() {
        throw new RuntimeException("Not implemented yet!");
    }

    /**
     * Clase interna del Nodo
     */
    private static class NodoSede {

        /**
         * The Sede.
         */
        private Sede sede;

        /**
         * The Siguiente.
         */
        private NodoSede siguiente;

        /**
         * The Anterior.
         */
        private NodoSede anterior;

        public NodoSede(Sede sede) {
            this.sede = sede;
        }

        /**
         * @return the Sede.
         */
        public Sede getSede() {
            return this.sede;
        }

        /**
         * @return the Siguiente.
         */
        public NodoSede getSiguiente() {
            return this.siguiente;
        }

        /**
         * @param siguiente the Siguiente to set.
         */
        public void setSiguiente(NodoSede siguiente) {
            this.siguiente = siguiente;
        }

        /**
         * @return the Anterior.
         */
        public NodoSede getAnterior() {
            return this.anterior;
        }

        /**
         * @param anterior the Anterior to set.
         */
        public void setAnterior(NodoSede anterior) {
            this.anterior = anterior;
        }
    }
}
