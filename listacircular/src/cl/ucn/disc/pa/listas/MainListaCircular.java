/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listas;

import cl.ucn.disc.pa.listas.colecciones.Elemento;
import cl.ucn.disc.pa.listas.colecciones.Lista;
import cl.ucn.disc.pa.listas.colecciones.ListaNexoSimpleCircular;
import cl.ucn.disc.pa.listas.model.Entero;

/**
 * The Main of Lista con Nexo Circulares.
 *
 * @author Programacion Avanzada.
 */
public final class MainListaCircular {

    /**
     * The Main.
     */
    public static void main(String[] args) {

        // instanciacion de la lista con nexo simple circular
        Lista lista = new ListaNexoSimpleCircular();

        // impresion de la lista
        System.out.println("Lista: " + lista);

        // check: tamanio
        if (lista.tamanio() != 0) {
            System.err.println("Error: la lista no esta vacia");
            System.exit(-1);
        }

        // insertar [ 0 1 2 .. 10 ]
        for (int i = 0; i <= 10; i++) {
            lista.agregar(new Entero(i));
        }

        // impresion de la lista luego de la insercion
        System.out.println("Lista: " + lista);

        // insertar el valor 11 en la posicion 11
        lista.agregar(11, new Entero(11));

        // impresion de la lista
        System.out.println("Lista: " + lista);

        // verificar la correcta insercion en la posicion 5
        Elemento e = lista.obtener(5);
        if (e == null || !e.esIgual(new Entero(5))) {
            System.err.println("Error: el elemento 5 no esta en la posicion 5 o es null");
            System.exit(-1);
        }

        // verificacion de la posicion del elemento 9
        if (lista.posicionDe(new Entero(9)) != 9) {
            System.err.println("Error: el elemento 9 no esta en la posicion 9");
            System.exit(-1);
        }

        // check: tamanio
        if (lista.tamanio() != 12) {
            System.err.println("Error: tamanio incorrecto, esperado 12, obtenido " + lista.tamanio());
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

        // eliminar todos los elementos en desorden
        lista.eliminar(new Entero(2));
        lista.eliminar(new Entero(8));
        lista.eliminar(new Entero(0));
        lista.eliminar(new Entero(9));
        lista.eliminar(new Entero(6));
        lista.eliminar(new Entero(11));
        lista.eliminar(new Entero(4));
        lista.eliminar(new Entero(3));
        lista.eliminar(new Entero(7));

        // check: la lista deberia estar vacia
        if (!lista.isVacia()) {
            System.err.println("Error: la lista no esta vacia y deberia estarlo!");
            System.exit(-1);
        }

        // impresion de la lista final
        System.out.println("Lista: " + lista);
    }
}
