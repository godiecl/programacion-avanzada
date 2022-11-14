/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listaenlazada.colecciones;

/**
 * The Lista Nexo Simple Doble.
 *
 * @author Programacion Avanzada.
 */
public final class ListaNexoDoble implements Lista {

    /**
     * The cabeza.
     */
    private NodoDoble cabeza;

    /**
     * The cola.
     */
    private NodoDoble cola;

    /**
     * The Lista con Nexo simple.
     */
    public ListaNexoDoble() {
        this.cabeza = null;
        this.cola = null;
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
        NodoDoble nuevo = new NodoDoble(e);

        // la lista esta vacia
        if (this.cabeza == null) {
            this.cabeza = nuevo;
            this.cola = nuevo;
            return true;
        }

        // la lista no esta vacia
        this.cabeza.setAnterior(nuevo);
        nuevo.setSiguiente(this.cabeza);

        // nuevo es la cabeza
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
        // busqueda desde la cabeza a la cola
        for (NodoDoble aux = this.cabeza; aux != null; aux = aux.getSiguiente()) {
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
            // en caso de que la lista tenga un solo elemento.
            // FIXME: Error en la codificacion
            if (this.cabeza != null) {
                this.cabeza.setAnterior(null);
            }
            return true;
        }

        // si el elemento a eliminar esta en el resto de la lista.
        for (NodoDoble aux = this.cabeza; aux != null; aux = aux.getSiguiente()) {
            if (aux.getSiguiente() != null && aux.getSiguiente().getElemento().esIgual(e)) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                // en caso de que el elemento a eliminar sea la cola.
                if (aux.getSiguiente() == null) {
                    this.cola = aux;
                }
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
        for (NodoDoble aux = this.cabeza; aux != null; aux = aux.getSiguiente()) {
            contador++;
        }
        return contador;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NodoDoble aux = this.cabeza; aux != null; aux = aux.getSiguiente()) {
            sb.append(aux.getElemento().toString()).append(",");
        }
        return sb.toString();
    }
}
