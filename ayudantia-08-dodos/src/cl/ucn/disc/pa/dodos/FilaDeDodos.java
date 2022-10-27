/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.dodos;

import cl.ucn.disc.pa.dodos.model.Dodo;

/**
 * Ayudantia 08: Fila de Dodos.
 *
 * @author Programacion Avanzada.
 */
public interface FilaDeDodos {

    /**
     * Agrega un dodo al inicio de la fila.
     *
     * @param dodo el dodo a agregar.
     */
    void agregarAlInicio(Dodo dodo);

    /**
     * Agrega un dodo al inicio de la fila.
     *
     * @param dodo     el dodo a agregar.
     * @param posicion la posicion en la que se agregara el dodo.
     */
    void agregarEnPosicion(Dodo dodo, int posicion);


    /**
     * Elimina un dodo de la fila.
     *
     * @param dodo el dodo a eliminar.
     */
    void sacar(Dodo dodo);

}
