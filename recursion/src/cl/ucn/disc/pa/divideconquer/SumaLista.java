/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.divideconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * The SumaLista en dividir para conquistar.
 *
 * @author Programacion Avanzada.
 */
public final class SumaLista {

    /**
     * The Main.
     *
     * @param args to use.
     */
    public static void main(String[] args) {
        // arreglo de numeros enteros
        List<Integer> numeros = new ArrayList<>();

        // llenar el arreglo
        for (int i = 0; i < 5; i++) {
            numeros.add((int) (Math.random() * 100 + 1));
        }

        // imprimir el arreglo
        System.out.print("[ ");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println("]");

        // sumar los elementos del arreglo
        System.out.println("Suma: " + sumar(numeros));
    }

    /**
     * Metodo para sumar los elementos de un arreglo.
     *
     * @param numeros lista de numeros a sumar.
     * @return la suma.
     */
    private static int sumar(List<Integer> numeros) {
        return sumar(numeros, 0, numeros.size() - 1);
    }

    /**
     * Metodo recursivo para sumar los elementos de un arreglo.
     *
     * @param numeros a sumar.
     * @param inicio  desde donde.
     * @param fin     hasta donde.
     * @return la suma.
     */
    private static int sumar(List<Integer> numeros, int inicio, int fin) {
        // si llegue a un arreglo de tamanio 1
        if (inicio == fin) {
            return numeros.get(inicio);
        }
        // mitad del arreglo
        int mitad = (inicio + fin) / 2;
        // suma de la primera mitad a la segunda mitad
        return sumar(numeros, inicio, mitad) + sumar(numeros, mitad + 1, fin);
    }
}
