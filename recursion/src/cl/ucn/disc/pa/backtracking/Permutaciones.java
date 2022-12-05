/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.backtracking;

/**
 * The Permutaciones de A B y C.
 *
 * @author Programacion Avanzada.
 */
public final class Permutaciones {

    /**
     * The Main.
     */
    public static void main(String[] args) {
        permutarABC("");
    }

    /**
     * Permuta las letras A, B y C.
     *
     * @param prefijo a utilizar.
     */
    private static void permutarABC(String prefijo) {
        // si el string es de tamanio 3 lo imprime
        if (prefijo.length() == 3) {
            System.out.println(prefijo);
        } else {
            // recorre las letras realizando la permutacion
            for (String letra : new String[]{"a", "b", "c"}) {
                permutarABC(prefijo + letra);
            }
            /*
            el ciclo de arriba es lo mismo que:
            String[] letras = new String[3];
            letras[0] = "a";
            letras[1] = "b";
            letras[2] = "c";
            for (int i = 0; i < letras.length; i++) {
                permutarABC(prefijo + letras[i]);
            }
            */
        }
    }
}
