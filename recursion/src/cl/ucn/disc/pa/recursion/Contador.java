/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.recursion;

/**
 * The Contador.
 *
 * @author Programacion Avanzada.
 */
public final class Contador {

    public static void main(String[] args) {
        contador(-1);
    }

    private static void contador(int n) {
        // condicion de salida
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        contador(n - 1);
    }
}
