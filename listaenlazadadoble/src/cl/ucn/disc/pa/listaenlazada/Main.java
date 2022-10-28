/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listaenlazada;

import cl.ucn.disc.pa.listaenlazada.colecciones.Lista;
import cl.ucn.disc.pa.listaenlazada.colecciones.ListaNexoDoble;
import cl.ucn.disc.pa.listaenlazada.model.Vehiculo;

/**
 * The Main of Lista Enlazada.
 *
 * @author Programacion Avanzada.
 */
public final class Main {

    /**
     * The Main.
     */
    public static void main(String[] args) {

        // instanciacion de la lista
        Lista lista = new ListaNexoDoble();

        // instanciar vehiculo
        Vehiculo vehiculo = new Vehiculo("LS4457", "Toyota", "Corolla");

        // agregar 3 vehiculos
        lista.agregar(vehiculo);
        lista.agregar(vehiculo);
        lista.agregar(vehiculo);

        // deberia ser 3
        System.out.println("Tamanio de la lista: " + lista.tamanio());

        // vaciar vehiculo
        lista.vaciar();

        // deberia ser 0
        System.out.println("Tamanio de la lista: " + lista.tamanio());

        // agregar 2 vehiculos
        lista.agregar(vehiculo);
        lista.agregar(vehiculo);

        // eliminar
        lista.eliminar(vehiculo);

        // deberia ser 1
        System.out.println("Tamanio de la lista: " + lista.tamanio());

        if (lista.contiene(vehiculo)) {
            System.out.println("El vehiculo esta en la lista");
        } else {
            System.out.println("El vehiculo no esta en la lista");
        }

        System.out.println("Lista vacia: " + lista.isVacia());
    }
}
