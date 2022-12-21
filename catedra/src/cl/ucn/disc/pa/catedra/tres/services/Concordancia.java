/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.catedra.tres.services;

/**
 * The Concordancia class.
 *
 * @author Programacion-Avanzada.
 */
public interface Concordancia {

    /**
     * Ingresa una palabra con su número de línea a la concordancia.
     *
     * @param palabra a agregar.
     * @param linea   donde se encuentra la palabra.
     * @return true si la palabra ya existe, false si no.
     */
    boolean addPalabra(String palabra, int linea);

    /**
     * Ingresa el significado de una palabra. Una palabra puede posee varios significados.
     *
     * @param palabra     a agregar.
     * @param significado de la palabra a agregar.
     * @return retorna verdadero si la palabra ya existe y falso si no.
     */
    boolean addSignificado(String palabra, String significado);

    /**
     * Retorna el número de veces que una palabra ha sido ingresada a la concordancia.
     *
     * @param palabra a buscar.
     * @return el numero de repeticiones.
     */
    int getRepeticiones(String palabra);

    /**
     * Retorna un arreglo de enteros conteniendo las líneas en las cuales fue ingresada la palabra.
     *
     * @param palabra a buscar.
     * @return the array of lines.
     */
    int[] getLineasPalabra(String palabra);

    /**
     * Numero de palabras en la concordancia.
     *
     * @return the number of words.
     */
    int getNumeroPalabras();

    /**
     * Elimina de la concordancia todas aquellas palabras que se repiten menos de “repeticiones” veces.
     *
     * @param repeticiones minimas a eliminar.
     * @return retorna el número de palabras que fueron removidas.
     */
    int removePalabras(int repeticiones);

    /**
     * Retorna un arreglo con las palabras de la concordancia ordenadas alfabéticamente.
     *
     * @return the array of words.
     */
    String[] getPalabrasAlfabetico();

    /**
     * Retorna un arreglo con las palabras de la concordancia ordenadas por número de repeticiones.
     *
     * @return the array of words.
     */
    String[] getPabrasFrecuencias();
}
