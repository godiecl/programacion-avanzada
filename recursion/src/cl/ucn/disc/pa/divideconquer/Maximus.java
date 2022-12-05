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
 * The Maximus.
 *
 * @author Programacion Avanzada.
 */
public final class Maximus {

    /**
     * The Main.
     *
     * @param args to use.
     */
    public static void main(String[] args) {
        // arreglo de numeros enteros
        List<Integer> numeros = new ArrayList<>();

        // llenar el arreglo
        for (int i = 0; i < 20; i++) {
            numeros.add((int) (Math.random() * 100 + 1));
        }

        // imprimir el arreglo
        System.out.print("[ ");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println("]");

        // buscar el valor maximo
        int posicion = maximus(numeros);
        System.out.printf("El numero mayor es %d y se encuentra en la posicion %d.", numeros.get(posicion), posicion);
    }

    /**
     * Busca el valor maximo en un arreglo de numeros enteros.
     *
     * @param arreglo el arreglo de numeros enteros.
     * @return la posicion del valor maximo.
     */
    public static int maximus(List<Integer> arreglo) {
        return maximus(arreglo, 0, arreglo.size() - 1);
    }

    /**
     * Busca el valor maximo en un arreglo de numeros enteros.
     *
     * @param arreglo el arreglo de numeros enteros.
     * @param inicio  el indice de inicio.
     * @param fin     el indice de fin.
     * @return la posicion del valor maximo.
     */
    private static int maximus(List<Integer> arreglo, int inicio, int fin) {
        // caso base
        if (inicio == fin) {
            return inicio;
        } else {
            // mitad y mitad
            int mitad = (inicio + fin) / 2;
            // mayor por la izquierda
            int posMaxIzq = maximus(arreglo, inicio, mitad);
            // mayor por la derecha
            int posMinDer = maximus(arreglo, mitad + 1, fin);
            // comparar los valores
            if (arreglo.get(posMaxIzq) > arreglo.get(posMinDer)) {
                return posMaxIzq;
            } else {
                return posMinDer;
            }
        }
    }
}
