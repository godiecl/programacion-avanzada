/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.divideconquer;

/**
 * The Potencia.
 *
 * @author Programacion Avanzada.
 */
public final class Power {

    /**
     * The Main.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(power(3, 5));
    }

    /**
     * Metodo para calcular la potencia de un numero.
     *
     * @param base     de la potencia.
     * @param exponent de la potencia.
     * @return la potencia.
     */
    private static long power(int base, int exponent) {
        // si el exponente es cero, la potencia es 1
        if (exponent == 0) {
            return 1;
        }

        // valor intermedio
        long power = power(base, exponent / 2);

        if (exponent % 2 == 0) {
            // si el exponente es par:
            // la potencia es la potencia de la base al cuadrado
            return power * power;
        } else {
            // si el exponente es impar:
            // la potencia es la potencia de la base al cuadrado multiplicada por la base
            return base * power * power;
        }

    }
}
