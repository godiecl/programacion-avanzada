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
     *
     * @param posicion a utilizar.
     * @param e        a agregar.
     */
    void agregar(int posicion, Elemento e);

    /**
     * Obtiene el elemento que se encuentra en la posicion indicada.
     *
     * @param posicion a obtener.
     * @return the Elemento.
     */
    Elemento obtener(int posicion);

    /**
     * Retorna la posicion del elemento e.
     *
     * @param e a identificar.
     * @return the posicion, -1 si no existe.
     */
    int posicionDe(Elemento e);

    /**
     * Elimina el elemento que se encuentra en la posicion indicada.
     *
     * @param posicion a eliminar.
     * @return the Elemento eliminado.
     */
    Elemento eliminar(int posicion);
}
