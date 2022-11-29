/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.recursion;

/**
 * The Inversion.
 *
 * @author Programacion Avanzada.
 */
public final class Invertir {

    /**
     * The Main.
     */
    public static void main(String[] args) {
        System.out.println(invertir("hola mundo".toLowerCase()));
        System.out.println(invertir("lavanesabasenaval".toLowerCase()));
    }

    /**
     * Funcion recursiva que invierte una cadena de caracteres.
     *
     * @param string la cadena de caracteres a invertir.
     * @return la cadena de caracteres invertida.
     */
    private static String invertir(String string) {
        // condicion de salida
        if (string.length() == 0) {
            return "";
        }
        return invertir(string.substring(1)) + string.charAt(0);
    }
}
