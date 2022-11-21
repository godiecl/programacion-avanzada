/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.diccionario;

/**
 * Interface de un IDiccionario.
 *
 * @author Programacion Avanzada.
 */
public interface IDiccionario {

    /**
     * Metodo que insertar una palabra y su significado en forma ordenada.
     *
     * @param palabra     a insertar.
     * @param significado a insertar.
     * @return true si fue posible la insercion.
     */
    boolean insertarPalabra(String palabra, String significado);

    /**
     * Metodo que elimina una palabra de la estructura, retorna true si fue posible la eliminacion y false si la palabra
     * a eliminar no existe en el diccionario.
     *
     * @param palabra a eliminar.
     * @return true si fue posible la eliminacion.
     */
    boolean eliminarPalabra(String palabra);

    /**
     * Metodo que retorna el significado de la palabra, si no lo encuentra retorna null.
     *
     * @param palabra a buscar.
     * @return el significado.
     */
    String buscarSignificado(String palabra);

    /**
     * Metodo que entrega un arreglo de String de todas las palabras del Diccionario ordenadas por orden alfabetico.
     *
     * @return the array of String.
     */
    String[] listadoPalabras();

    /**
     * Metodo que entrega un arreglo de String de todas las palabras que comienzan con la letra.
     *
     * @param letra a buscar como prefijo.
     * @return arreglo de palabras.
     */
    String[] listadoPalabras(String letra);

    /**
     * Retorna la cantidad de palabras en total que tiene el Diccionario.l
     *
     * @return the tamanio.
     */
    int cantidadDePalabras();

}
