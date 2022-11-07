/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listas.colecciones;

/**
 * La Lista Ligada con Nodo simple y mas encima circular.
 *
 * <p>Esta implementacion utiliza la clase interna Nodo.
 *
 * @author Programacion Avanzada.
 */
public final class ListaNexoSimpleCircular implements Lista {

    /**
     * El primer nodo.
     */
    private NodoSimpleCircular primero;

    /**
     * El ultimo nodo.
     */
    private NodoSimpleCircular ultimo;

    /**
     * Constructor vacio.
     */
    public ListaNexoSimpleCircular() {
        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Agrega un elemento a la coleccion.
     *
     * @param e the elemento a agregar.
     * @return true si el elemento fue agregado.
     */
    @Override
    public boolean agregar(Elemento e) {

        // el constructor del nodo verifica la nulidad
        NodoSimpleCircular nuevo = new NodoSimpleCircular(e);

        // caso lista vacia
        if (this.isVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            this.primero.siguiente = this.ultimo;
            return true;
        }

        // caso lista con elementos: inserto al final
        nuevo.siguiente = this.primero;
        ultimo.siguiente = nuevo;
        ultimo = nuevo;
        return true;
    }

    /**
     * Retorna true si el elemento esta en la coleccion.
     *
     * @param e a buscar.
     * @return true si lo encontre.
     */
    @Override
    public boolean contiene(Elemento e) {

        // lista vacia
        if (this.primero == null) {
            return false;
        }

        NodoSimpleCircular aux = this.primero;
        do {
            if (aux.elemento.esIgual(e)) {
                return true;
            }
            aux = aux.siguiente;
        } while (aux != this.primero);

        return false;
    }

    /**
     * Elimina un Elemento de la coleccion.
     *
     * @param e the elemento a eliminar.
     * @return true si fue posible eliminarlo.
     */
    @Override
    public boolean eliminar(Elemento e) {
        // lista vacia
        if (this.isVacia()) {
            return false;
        }

        // nodo anterior al elemento a eliminar
        NodoSimpleCircular anterior = this.buscarNodoAnteriorAlElemento(e);

        // no lo encontre!
        if (anterior == null) {
            return false;
        }

        // caso: elemento a eliminar es el primero y el ultimo
        if (anterior == this.primero && anterior == this.ultimo) {
            this.primero = null;
            this.ultimo = null;
            return true;
        }

        // caso: el elemento a eliminar es el primero
        if (anterior.siguiente == this.primero) {
            this.primero = this.primero.siguiente;
            this.ultimo.siguiente = this.primero;
            return true;
        }

        // caso: el elemento a eliminar es el ultimo
        if (anterior.siguiente == this.ultimo) {
            this.ultimo = anterior;
            this.ultimo.siguiente = this.primero;
            return true;
        }

        // caso: el elemento a eliminar esta en el medio
        anterior.siguiente = anterior.siguiente.siguiente;

        return false;
    }

    /**
     * Retorna el nodo que se encuentra justo antes del elemento a eliminar.
     *
     * @return el nodo anterior.
     */
    private NodoSimpleCircular buscarNodoAnteriorAlElemento(Elemento e) {
        // lista vacia
        if (this.isVacia()) {
            return null;
        }

        // el elemento esta en el primer lugar
        if (this.primero.elemento.esIgual(e)) {
            return this.ultimo;
        }

        // busqueda del nodo anterior
        NodoSimpleCircular aux = this.primero;
        do {
            if (aux.siguiente.elemento.esIgual(e)) {
                return aux;
            }
            aux = aux.siguiente;
        } while (aux != this.primero);

        // no lo encontre
        return null;
    }

    /**
     * Elimina todos los elementos de la coleccion.
     */
    @Override
    public void vaciar() {
        this.primero = null;
    }

    /**
     * Tamanio de la coleccion.
     *
     * @return true si la coleccion esta vacia.
     */
    @Override
    public boolean isVacia() {
        return this.primero == null;
    }

    /**
     * Numero de elementos en la lista.
     *
     * @return el numero de elementos en la coleccion.
     */
    @Override
    public int tamanio() {
        // lista vacia
        if (this.primero == null) {
            return 0;
        }

        // lista con 1 elemento
        if (this.primero.siguiente == this.primero) {
            return 1;
        }

        // lista con mas de 1 elemento
        int cantidad = 1;
        for (NodoSimpleCircular aux = this.primero.siguiente; aux != this.primero; aux = aux.siguiente) {
            cantidad++;
        }

        return cantidad;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        // lista vacia
        if (this.isVacia()) {
            return "[ ]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        NodoSimpleCircular aux = this.primero;
        do {
            sb.append(aux.elemento).append(" ");
            aux = aux.siguiente;
        } while (aux != this.primero);

        sb.append("]");
        return sb.toString();
    }

    /**
     * The internal Nodo class.
     *
     * @author Programacion Avanzada.
     */
    private static final class NodoSimpleCircular {

        /**
         * The Elemento.
         */
        final Elemento elemento;

        /**
         * The siguiente.
         */
        NodoSimpleCircular siguiente;

        /**
         * The Constructor.
         *
         * @param elemento to set.
         */
        public NodoSimpleCircular(Elemento elemento) {
            // verificacion de parametros
            if (elemento == null) {
                throw new IllegalArgumentException("Elemento nulo!");
            }
            this.elemento = elemento;
        }

        /**
         * Returns a string representation of the object.
         */
        @Override
        public String toString() {
            return this.elemento.toString();
        }
    }
}
