/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.diccionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * The class to implements the IDiccionario.
 *
 * @author Programacion Avanzada.
 */
public final class DiccionarioImpl implements IDiccionario {

    /**
     * El indice de las letras.
     */
    private final List<Entrada> indice;

    /**
     * The Constructor.
     */
    public DiccionarioImpl() {

        // instanciacion del indice
        this.indice = new LinkedList<>();

        // creacion de cada valor en el indice
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            this.indice.add(new Entrada(letra));
        }

    }

    /**
     * Metodo que insertar una palabra y su significado en forma ordenada.
     *
     * @param palabra     a insertar.
     * @param significado a insertar.
     * @return true si fue posible la insercion.
     */
    @Override
    public boolean insertarPalabra(String palabra, String significado) {

        // validacion de palabra
        if (palabra == null || palabra.length() == 0) {
            throw new IllegalArgumentException("La palabra se encuentra vacia");
        }

        // validacion de significado
        if (significado == null || significado.length() == 0) {
            throw new IllegalArgumentException("El significado se encuentra vacio");
        }

        // creacion del concepto a insertar en el diccionario
        Concepto concepto = new Concepto(palabra, significado);

        // busqueda de la lista donde deberia ser insertado el concepto
        for (Entrada entrada : this.indice) {
            // la primera letra de la palabra es la que busco
            if (entrada.pertenece(concepto.palabra)) {
                // inserto en la entrada
                entrada.insertar(concepto);
                // todo ok
                return true;
            }
        }

        // no encontre la letra?
        return false;
    }

    /**
     * Metodo que elimina una palabra de la estructura, retorna true si fue posible la eliminacion y false si la palabra
     * a eliminar no existe en el diccionario.
     *
     * @param palabra a eliminar.
     * @return true si fue posible la eliminacion.
     */
    @Override
    public boolean eliminarPalabra(String palabra) {
        // recorro el indice
        for (Entrada entrada : indice) {

            // si encontre la entrada donde va la palabra
            if (entrada.pertenece(palabra)) {

                // NOTA: el siguiente for puede ser reemplazado por la siguiente linea:
                // entrada.conceptos.removeIf(concepto -> concepto.palabra.equals(palabra));

                // busco el concepto para su eliminacion
                for (Concepto concepto : entrada.conceptos) {

                    // elimino el concepto
                    if (concepto.palabra.equals(palabra)) {
                        entrada.conceptos.remove(concepto);
                        return true;
                    }
                }

                return false;
            }
        }
        return false;
    }

    /**
     * Metodo que retorna el significado de la palabra, si no lo encuentra retorna null.
     *
     * @param palabra a buscar.
     * @return el significado.
     */
    @Override
    public String buscarSignificado(String palabra) {
        // recorro el indice
        for (Entrada entrada : indice) {
            // encontre el lista
            if (entrada.pertenece(palabra)) {
                // recorro la lista
                for (Concepto concepto : entrada.conceptos) {
                    // encontre la palabral
                    if (concepto.palabra.equals(palabra)) {
                        return concepto.significado;
                    }
                }
                return null;
            }
        }
        return null;
    }

    /**
     * Metodo que entrega un arreglo de String de todas las palabras del Diccionario ordenadas por orden alfabetico.
     *
     * @return the array of String.
     */
    @Override
    public String[] listadoPalabras() {

        // arreglo de palabras
        String[] palabras = new String[this.cantidadDePalabras()];

        // posicion
        int posicion = 0;

        // recorro el indice
        for (Entrada entrada : this.indice) {

            // recorro los conceptos
            for (Concepto concepto : entrada.conceptos) {
                // agrego al arreglo
                palabras[posicion] = concepto.palabra;
                // incremento posicion
                posicion++;
            }
        }
        return palabras;
    }

    /**
     * Metodo que entrega un arreglo de String de todas las palabras que comienzan con la letra.
     *
     * @param letra a buscar como prefijo.
     * @return arreglo de palabras.
     */
    @Override
    public String[] listadoPalabras(String letra) {

        List<String> palabras = new ArrayList<>();

        for (Entrada entrada : this.indice) {

            for (Concepto concepto : entrada.conceptos) {

                if (concepto.palabra.startsWith(letra)) {
                    palabras.add(concepto.palabra);
                }
            }
        }

        // NOTA: el siguiente codigo puede ser reemplazado por la siguiente linea:
        // return palabras.toArray(new String[0]);
        String[] arrPalabras = new String[palabras.size()];
        int posicion = 0;
        for (String palabra : palabras) {
            arrPalabras[posicion] = palabra;
            posicion++;
        }

        return arrPalabras;
    }

    /**
     * Retorna la cantidad de palabras en total que tiene el Diccionario.l
     *
     * @return the tamanio.
     */
    @Override
    public int cantidadDePalabras() {
        int total = 0;
        for (Entrada entrada : this.indice) {
            total += entrada.tamanio();
        }
        return total;
    }

    /**
     * Clase interna (inner) de un Concepto del DiccionarioImpl.
     *
     * @author Programacion Avanzada.
     */
    private static final class Concepto {

        /**
         * La palabra.
         */
        final String palabra;

        /**
         * El significado.
         */
        final String significado;

        /**
         * The Constructor.
         */
        Concepto(String palabra, String significado) {
            // CANCION --> Cancion
            // cancion --> Cancion
            // CanCION --> Cancion
            this.palabra = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
            this.significado = significado;
        }

    }

    /**
     * Clase interna (inner) que representa una Entrada en el indice de un Diccionario.
     *
     * @author Programacion Avanzada.
     */
    private static final class Entrada {

        /**
         * La letra: ej: A.
         */
        final char letra;

        /**
         * Lista de palabras que comienzan con la letra.
         */
        final List<Concepto> conceptos;

        /**
         * The Constructor.
         *
         * @param letra a usar.
         */
        Entrada(char letra) {
            this.letra = letra;
            this.conceptos = new LinkedList<>();
        }

        /**
         * Numero de palabras con la letra.
         *
         * @return el tamanio.
         */
        int tamanio() {
            return this.conceptos.size();
        }

        /**
         * Identifica si una palabra pertenece a esta Entrada.
         *
         * @param palabra a verificar.
         * @return true si la palabra comienza con la letra de esta entrada.
         */
        boolean pertenece(String palabra) {
            return palabra.charAt(0) == this.letra;
        }

        /**
         * Inserta el Concepto en la lista en forma ordenada.l
         *
         * @param concepto a insertar.
         */
        void insertar(Concepto concepto) {

            // inserto en la lista
            this.conceptos.add(concepto);

            // ordeno la lista utilizando un comparador por palabra
            this.conceptos.sort(Comparator.comparing(concept -> concept.palabra));

        }
    }

}
