/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.recursion;

/**
 * The Fibonacci.
 *
 * @author Programacion Avanzada.
 */
public final class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }

    /**
     * Funcion recursiva que calcula el n-esimo numero de la serie de Fibonacci.
     *
     * @param n el numero de la serie de Fibonacci a calcular.
     * @return el n-esimo numero de la serie de Fibonacci.
     */
    private static int fibonacci(int n) {
        // condicion de salida
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
