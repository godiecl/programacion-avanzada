/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listas.colecciones;

/**
 * The Elemento.
 *
 * @author Programacion Avanzada.
 */
public interface Elemento {

    /**
     * Realiza la comparacion entre dos Elementos.
     *
     * @param e elemento a comparar.
     * @return true si ambos elementos son iguales.
     */
    boolean esIgual(Elemento e);

    /**
     * Realiza la comparacion de tamanio entre dos Elementos.
     *
     * @param e elemento a comparar.
     * @return 0 si son iguales, -1 is es menor, 1 si es mayor.
     */
    int compararCon(Elemento e);

}
