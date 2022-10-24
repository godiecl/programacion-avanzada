/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listaenlazada.colecciones;

/**
 * The Lista Nexo Simple.
 *
 * @author Programacion Avanzada.
 */
public final class ListaNexoSimple implements Lista {

    /**
     * The cabeza.
     */
    private Nodo cabeza;

    /**
     * The Lista con Nexo simple.
     */
    public ListaNexoSimple() {
        this.cabeza = null;
    }

    /**
     * Agrega un elemento a la coleccion.
     *
     * @param e the elemento a agregar.
     * @return true si el elemento fue agregado.
     */
    @Override
    public boolean agregar(Elemento e) {
        // noodo a insertar.
        Nodo nuevo = new Nodo(e);

        // el siguiente del nuevo nodo es la cabeza.
        nuevo.setSiguiente(this.cabeza);

        // la cabeza es el nuevo nodo.
        this.cabeza = nuevo;

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
        for (Nodo aux = this.cabeza; aux != null; aux = aux.getSiguiente()) {
            if (aux.getElemento().esIgual(e)) {
                return true;
            }
        }
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

        // si la lista esta vacia, no hay nada que eliminar.
        if (this.isVacia()) {
            return false;
        }

        // si el elemento a eliminar es la cabeza.
        if (this.cabeza.getElemento().esIgual(e)) {
            this.cabeza = this.cabeza.getSiguiente();
            return true;
        }

        // si el elemento a eliminar esta en el resto de la lista.
        for (Nodo aux = this.cabeza; aux.getSiguiente() != null; aux = aux.getSiguiente()) {
            if (aux.getSiguiente().getElemento().esIgual(e)) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina todos los elementos de la coleccion.
     */
    @Override
    public void vaciar() {
        this.cabeza = null;
    }

    /**
     * @return true si la coleccion esta vacia.
     */
    @Override
    public boolean isVacia() {
        return this.cabeza == null;
    }

    /**
     * @return el numero de elementos en la coleccion.
     */
    @Override
    public int tamanio() {
        int contador = 0;
        for (Nodo aux = this.cabeza; aux != null; aux = aux.getSiguiente()) {
            contador++;
        }
        return contador;
    }
}
