/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.recursion;

/**
 * The G.
 *
 * @author Programacion Avanzada.
 */
public final class G {

    public static void main(String[] args) {
        System.out.println("G(G(2)) = " + g(g(2)));
    }

    private static int f(int n) {
        if (n == 0) {
            return 1;
        }
        return f(n - 1) + g(n - 1);
    }

    private static int g(int n) {
        if (n == 0) {
            return 0;
        }
        return g(n - 1) + f(n);
    }
}
