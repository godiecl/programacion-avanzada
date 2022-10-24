/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listaenlazada.colecciones;

/**
 * The Coleccionl.
 *
 * @author Programacion Avanzada.
 */
public interface Coleccion {

    /**
     * Agrega un elemento a la coleccion.
     *
     * @param e the elemento a agregar.
     * @return true si el elemento fue agregado.
     */
    boolean agregar(Elemento e);

    /**
     * Retorna true si el elemento esta en la coleccion.
     *
     * @param e a buscar.
     * @return true si lo encontre.
     */
    boolean contiene(Elemento e);

    /**
     * Elimina un Elemento de la coleccion.
     *
     * @param e the elemento a eliminar.
     * @return true si fue posible eliminarlo.
     */
    boolean eliminar(Elemento e);

    /**
     * Elimina todos los elementos de la coleccion.
     */
    void vaciar();

    /**
     * @return true si la coleccion esta vacia.
     */
    boolean isVacia();

    /**
     * @return el numero de elementos en la coleccion.
     */
    int tamanio();

}
