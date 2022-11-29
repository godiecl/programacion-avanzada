/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.recursion;

/**
 * The Incognita.
 *
 * @author Programacion Avanzada.
 */
public final class Misterio {

    /**
     * The Main.
     */
    public static void main(String[] args) {
        System.out.println(misterio(2, 25));
        System.out.println(misterio(3, 11));
    }

    /**
     * Funcion recursiva que ___?.
     *
     * @param a valor a usar.
     * @param b valor a usar.
     * @return un misterio.
     */
    private static long misterio(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return misterio(a + a, b / 2);
        }
        return misterio(a + a, b / 2) + a;
    }

}
