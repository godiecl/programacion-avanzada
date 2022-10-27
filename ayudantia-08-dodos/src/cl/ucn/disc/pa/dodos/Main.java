/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.dodos;

import cl.ucn.disc.pa.dodos.model.Dodo;

/**
 * The Main.
 *
 * @author Programacion Avanzada.
 */
public final class Main {

    /**
     * The Main.
     */
    public static void main(String[] args) {

        // la lista
        FilaDeDodos fila = new FilaDeDodosNexos();

        // insertar dodos en la final
        fila.agregarAlInicio(new Dodo("Mijail",2, 1));
        fila.agregarAlInicio(new Dodo("Draco",1, 3));
        fila.agregarAlInicio(new Dodo("Lola",1, 9));
        fila.agregarAlInicio(new Dodo("Nigel",3, 5));
        fila.agregarAlInicio(new Dodo("Kiara",2, 8));
        fila.agregarEnPosicion(new Dodo("Lechuga",4, 10), 3);
        fila.agregarEnPosicion(new Dodo("Pandora",2, 5), 1);

        // imprimir la fila
        System.out.println(fila);

        // sacar
        fila.sacar(new Dodo("Kiara",2, 8));

        // imprimir la fila
        System.out.println(fila);
    }
}
