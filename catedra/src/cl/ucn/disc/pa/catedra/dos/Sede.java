/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.catedra.dos;

/**
 * The Sede.
 *
 * @author Programacion Avanzada.
 */
public final class Sede {

    /**
     * The Rut.
     */
    private final String rut;

    /**
     * The Nombre.
     */
    private final String nombre;

    /**
     * The Distancia.
     */
    private final double distancia;

    /**
     * The Constructor.
     *
     * @param rut       to use.
     * @param nombre    to use.
     * @param distancia to use.
     */
    public Sede(String rut, String nombre, double distancia) {
        // TODO: Add validations
        this.rut = rut;
        this.nombre = nombre;
        this.distancia = distancia;
    }

    /**
     * @return the rut.
     */
    public String getRut() {
        return this.rut;
    }

    /**
     * @return the distancia.
     */
    public double getDistancia() {
        return this.distancia;
    }

    public boolean agregarEstudiante(Estudiante estudiante) {
        return true;
    }

    public Estudiante buscarEstudiante(String rutEstudiante) {
        return null;
    }

    public boolean eliminarEstudiante(String rutEstudiante) {
        return true;
    }


    public int cantidadDeEstudiantes() {
        return 0;
    }

    public Estudiante getEstudiante(int posicion) {
        return null;
    }
}
