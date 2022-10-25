/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listaenlazada.colecciones;

/**
 * The Lista Arreglo Estatico.
 *
 * @author Programacion Avanzada.
 */
public final class ListaArregloEstatico implements Lista {

    /**
     * The array.
     */
    private Elemento[] arreglo;

    /**
     * The numero de elementos.
     */
    private int numeroElementos;

    /**
     * Construye la lista basada en un arreglo estatico.
     *
     * @param capacidad maxima de la lista.
     */
    public ListaArregloEstatico(int capacidad) {
        this.arreglo = new Elemento[capacidad];
        this.numeroElementos = 0;
    }

    /**
     * Agrega un elemento a la coleccion.
     *
     * @param e the elemento a agregar.
     * @return true si el elemento fue agregado.
     */
    @Override
    public boolean agregar(Elemento e) {
        for (int i = 0; i < this.arreglo.length; i++) {
            if (this.arreglo[i] == null) {
                this.arreglo[i] = e;
                this.numeroElementos++;
                return true;
            }
        }
        throw new IndexOutOfBoundsException("No hay mas espacio en la lista: tamanio maximo: " + this.arreglo.length);
    }

    /**
     * Retorna true si el elemento esta en la coleccion.
     *
     * @param e a buscar.
     * @return true si lo encontre.
     */
    @Override
    public boolean contiene(Elemento e) {
        for (Elemento actual : this.arreglo) {
            if (actual != null && actual.esIgual(e)) {
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
        for (int i = 0; i < this.arreglo.length; i++) {
            if (this.arreglo[i] != null && this.arreglo[i].esIgual(e)) {
                this.arreglo[i] = null;
                this.numeroElementos--;
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
        // re-inicializar el arreglo
        this.arreglo = new Elemento[this.arreglo.length];
    }

    /**
     * @return true si la coleccion esta vacia.
     */
    @Override
    public boolean isVacia() {
        return this.numeroElementos == 0;
    }

    /**
     * @return el numero de elementos en la coleccion.
     */
    @Override
    public int tamanio() {
        return this.numeroElementos;
    }
}
