/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listas.model;

import cl.ucn.disc.pa.listas.colecciones.Elemento;

/**
 * The Entero.
 *
 * @author Programacion Avanzada.
 */
public final class Entero implements Elemento {

    /**
     * The Value.
     */
    private final int valor;

    /**
     * Constructor de Entero.
     *
     * @param value a usar.
     */
    public Entero(int value) {
        this.valor = value;
    }

    /**
     * @return the Value.
     */
    public int getValor() {
        return this.valor;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        return Integer.toString(this.valor);
    }

    /**
     * Realiza la comparacion entre dos Elementos.
     *
     * @param e elemento a comparar.
     * @return true si ambos elementos son iguales.
     */
    @Override
    public boolean esIgual(Elemento e) {
        if (this == e) {
            return true;
        }
        if (e instanceof Entero) {
            return this.valor == ((Entero) e).valor;
        }
        return false;
    }

    /**
     * Realiza la comparacion de tamanio entre dos Elementos.
     *
     * @param e elemento a comparar.
     * @return 0 si son iguales, -1 is es menor, 1 si es mayor.
     */
    @Override
    public int compararCon(Elemento e) {
        if (this == e) {
            return 0;
        }
        if (e instanceof Entero) {
            return Integer.compare(this.valor, ((Entero) e).valor);
        }

        throw new IllegalArgumentException("Elemento no es un Entero");
    }
}
