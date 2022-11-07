/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listas;

import cl.ucn.disc.pa.listas.colecciones.Lista;
import cl.ucn.disc.pa.listas.colecciones.ListaNexoSimpleCircular;
import cl.ucn.disc.pa.listas.model.Entero;

/**
 * The Main of Lista.
 *
 * @author Programacion Avanzada.
 */
public final class MainListaCircular {

    /**
     * The Main.
     */
    public static void main(String[] args) {

        // instanciacion de la lista
        Lista lista = new ListaNexoSimpleCircular();

        // Impresion de la lista
        System.out.println("Lista: " + lista);

        // check: tamanio
        if (lista.tamanio() != 0) {
            System.err.println("Error: la lista no esta vacia");
            System.exit(-1);
        }

        // insertar [ 1 2 .. 10 ]
        for (int i = 1; i <= 10; i++) {
            lista.agregar(new Entero(i));
        }

        // Impresion de la lista
        System.out.println("Lista: " + lista);

        // check: tamanio
        if (lista.tamanio() != 10) {
            System.err.println("Error: tamanio incorrecto, esperado 10, obtenido " + lista.tamanio());
            System.exit(-1);
        }

        // check: contiene
        if (!lista.contiene(new Entero(5))) {
            System.err.println("Error: el 5 no esta en la lista y DEBERIA estar!");
            System.exit(-1);
        }

        // eliminar el 1 y verificar
        lista.eliminar(new Entero(1));
        if (lista.contiene(new Entero(1))) {
            System.err.println("Error: el 1 esta en la lista y NO deberia estar!");
            System.exit(-1);
        }

        // eliminar el 10
        lista.eliminar(new Entero(10));
        if (lista.contiene(new Entero(10))) {
            System.err.println("Error: el 10 esta en la lista y NO deberia estar!");
            System.exit(-1);
        }

        // eliminar el 5
        lista.eliminar(new Entero(5));
        if (lista.contiene(new Entero(5))) {
            System.err.println("Error: el 5 esta en la lista y NO deberia estar!");
            System.exit(-1);
        }

        lista.eliminar(new Entero(2));
        lista.eliminar(new Entero(8));
        lista.eliminar(new Entero(9));
        lista.eliminar(new Entero(6));
        lista.eliminar(new Entero(4));
        lista.eliminar(new Entero(3));
        lista.eliminar(new Entero(7));

        if (!lista.isVacia()) {
            System.err.println("Error: la lista no esta vacia y deberia estarlo!");
            System.exit(-1);
        }

        // Impresion de la lista
        System.out.println("Lista: " + lista);
    }
}
