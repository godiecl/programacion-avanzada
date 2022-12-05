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
public final class ListaEstudianteNexoDoble {

    /**
     * The Nodo de la Lista.
     */
    private NodoEstudiante primero;

    /**
     * The Nodo de la Lista.
     */
    private NodoEstudiante ultimo;

    /**
     * The Constructor.
     */
    public ListaEstudianteNexoDoble() {
        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Agrega un estudiantes a la lista.
     *
     * @param estudiante a agregar.
     * @return true si fue posible agregarlo.
     */
    public boolean agregar(Estudiante estudiante) {
        // noodo a insertar.
        NodoEstudiante nuevo = new NodoEstudiante(estudiante);

        // la lista esta vacia
        if (this.primero == null) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            return true;
        }

        // la lista no esta vacia
        this.primero.setAnterior(nuevo);
        nuevo.setSiguiente(this.primero);

        // nuevo es la cabeza
        this.primero = nuevo;

        return true;
    }

    public void eliminar(String rut) {
        throw new RuntimeException("Not implemented yet!");
    }

    public Estudiante buscar(String rut) {
        throw new RuntimeException("Not implemented yet!");
    }

    public int cantidadDeEstudiantes() {
        throw new RuntimeException("Not implemented yet!");
    }

    /**
     * Clase interna del Nodo
     */
    private static class NodoEstudiante {

        /**
         * The Estudiante.
         */
        private Estudiante estudiante;

        /**
         * The Siguiente.
         */
        private NodoEstudiante siguiente;

        /**
         * The Anterior.
         */
        private NodoEstudiante anterior;

        /**
         * The Constructor.
         *
         * @param estudiante to use.
         */
        public NodoEstudiante(Estudiante estudiante) {
            this.estudiante = estudiante;
        }

        /**
         * @return the Estudiante.
         */
        public Estudiante getEstudiante() {
            return this.estudiante;
        }

        /**
         * @return the Siguiente.
         */
        public NodoEstudiante getSiguiente() {
            return this.siguiente;
        }

        /**
         * @param siguiente the Siguiente to set.
         */
        public void setSiguiente(NodoEstudiante siguiente) {
            this.siguiente = siguiente;
        }

        /**
         * @return the Anterior.
         */
        public NodoEstudiante getAnterior() {
            return this.anterior;
        }

        /**
         * @param anterior the Anterior to set.
         */
        public void setAnterior(NodoEstudiante anterior) {
            this.anterior = anterior;
        }
    }
}
