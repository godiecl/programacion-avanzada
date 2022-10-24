/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft;

import cl.ucn.disc.pa.mandiosoft.services.Sistema;
import cl.ucn.disc.pa.mandiosoft.services.SistemaImpl;

import java.nio.file.Paths;

/**
 * The Mandiosoft.
 *
 * @author Programacion Avanzada.
 */
public final class Main {

    /**
     * The Main.
     */
    public static void main(String[] args) {

        // The current directory
        String rootPath = Paths.get("mandiosoft").toAbsolutePath().toString();

        // Call the Sistema
        Sistema sistema = new SistemaImpl(rootPath);

        // 1.
        System.out.println(sistema.getProyectosConCostos());

        // 2.
        System.out.println(sistema.getListadoFuncionariosConSueldo());

        // 3.
        System.out.println(sistema.getFuncionarios("123"));

        // 4.
        System.out.println(sistema.getProyectos("11893826-7"));

    }
}
