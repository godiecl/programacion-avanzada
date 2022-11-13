/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.lists;

import cl.ucn.disc.pa.lists.model.Entero;

import java.util.LinkedList;
import java.util.List;

/**
 * The Main of List, ArrayList and LinkedList.
 *
 * @author Programacion Avanzada.
 */
public final class MainLists {

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

        // Construimos la representacion de la lista
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Entero entero : lista) {
            sb.append(entero).append(" ");
        }
        sb.append("]");

        // Imprimimos la lista
        System.out.println("Lista: " + sb.toString());
    }

}

