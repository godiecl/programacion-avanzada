/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.iterator.model;

/**
 * The Entero.
 *
 * @author Programacion Avanzada.
 */
public final class Entero {

    /**
     * The valor.
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
     * El valor del entero.
     *
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
     * @param o elemento a comparar.
     * @return true si ambos elementos son iguales.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Entero) {
            return this.valor == ((Entero) o).valor;
        }
        return false;
    }

}
