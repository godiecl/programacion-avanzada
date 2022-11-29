/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.recursion;

/**
 * The Factorial.
 *
 * @author Programacion Avanzada.
 */
public final class Factorial {

    /**
     * The Main.
     */
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static long factorial(int n) {
        // condicion de salida
        // 1! = 1, 0! = 1
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
