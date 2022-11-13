/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.iterator;

import cl.ucn.disc.pa.iterator.model.Entero;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The Main Iterator.
 *
 * @author Programacion Avanzada.
 */
public final class MainIterator {

    /**
     * The main.
     */
    public static void main(String[] args) {

        // Creacion de la Lista
        List<Entero> lista = new LinkedList<>();
        // List<Entero> lista = new ArrayList<>();

        // Agregamos elementos
        for (int i = 0; i < 10; i++) {
            lista.add(new Entero(i));
        }

        System.out.println("Numero de elementos: " + lista.size());

        // Iterador
        Iterator<Entero> listaIterator = lista.iterator();

        // Recorrido de la lista utilizando el iterator
        while (listaIterator.hasNext()) {
            Entero entero = listaIterator.next();
            System.out.println(entero);
        }

        // Recorrido de la lista utilizando la posicion
        for (int i = 0; i < lista.size(); i++) {
            Entero entero = lista.get(i);
            System.out.println(entero);
        }

        // Recorrido de la lista utilizando un for mejorado
        for (Entero entero : lista) {
            System.out.println(entero);
        }

    }

}
