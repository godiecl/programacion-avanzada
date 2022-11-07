/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listas.colecciones;

/**
 * The Lista.
 *
 * @author Programacion Avanzada.
 */
public interface Lista extends Coleccion {

    /**
     * Agrega el Elemento en la posicion indicada.
     * @param posicion a utilizar.
     * @param e a agregar.
     */
    void agregar(int posicion, Elemento e);

}
