/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.recursion;

/**
 * Recursion.
 *
 * @author Programacion Avanzada.
 */
public final class Main {

    /**
     * Program entry point.
     */
    public static void main(String[] args) {
        // llamado a la recursion
        recursion();
    }

    /**
     * Metodo recursivo.
     */
    private static void recursion() {
        System.out.println("Hola Mundo!");
        // llamado a la recursion
        recursion();
    }

}
