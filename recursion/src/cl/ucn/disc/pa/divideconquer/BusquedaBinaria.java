/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.divideconquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Busqueda Binaria.
 *
 * @author Programacion Avanzada.
 */
public final class BusquedaBinaria {

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

        // ordenar el arreglo
        Collections.sort(numeros);

        // imprimir el arreglo
        System.out.print("[ ");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println("]");

        // buscar el numero 50
        int posicion = binarySearch(numeros, 0, numeros.size() - 1, 50);
        if (posicion == -1) {
            System.out.println("El numero no se encuentra en el arreglo");
        } else {
            System.out.println("El numero se encuentra en la posicion " + posicion);
        }

    }

    /**
     * The Busqueda Binaria.
     *
     * @param arreglo donde se busca el numero.
     * @param inicio  posicion inicial del arreglo.
     * @param fin     posicion final del arreglo.
     * @param buscado numero que se busca.
     * @return posicion del numero buscado.
     */
    private static int binarySearch(List<Integer> arreglo, int inicio, int fin, int buscado) {
        // si el inicio es mayor que el fin, el numero no se encuentra en el arreglo
        if (fin >= inicio) {

            // calcular el punto medio
            int medio = inicio + (fin - inicio) / 2;

            // si el numero buscado es igual al numero del punto medio, retornar el punto medio
            if (arreglo.get(medio) == buscado) {
                return medio;
            }

            // si el numero buscado es menor que el numero del punto medio, buscar en la mitad izquierda
            if (arreglo.get(medio) > buscado) {
                return binarySearch(arreglo, inicio, medio - 1, buscado);
            }

            // si el numero buscado es mayor que el numero del punto medio, buscar en la mitad derecha
            return binarySearch(arreglo, medio + 1, fin, buscado);
        }

        // si el numero no se encuentra en el arreglo, retornar -1
        return -1;
    }


}
