/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.dodos.model;

/**
 * The Dodo.
 *
 * @author Programacion Avanzada.
 */
public final class Dodo {

    /**
     * El nombre.
     */
    private final String nombre;

    /**
     * La edad.
     */
    private final int edad;

    /**
     * El grado.
     */
    private final int grado;

    /**
     * El constructor de un Dodo.
     *
     * @param nombre el nombre.
     * @param edad   la edad.
     * @param grado  el grado.
     */
    public Dodo(String nombre, int edad, int grado) {
        // TODO: Agregar validaciones.
        this.nombre = nombre;
        this.edad = edad;
        this.grado = grado;
    }

    /**
     * @return the Nombre.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return the Edad.
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * @return the Grado.
     */
    public int getGrado() {
        return this.grado;
    }
}
