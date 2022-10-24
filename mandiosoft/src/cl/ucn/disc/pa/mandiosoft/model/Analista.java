/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft.model;

/**
 * The Analista.
 *
 * @author Programacion Avanzada.
 */
public final class Analista extends Funcionario {

    /**
     * Anios de Experiencia.
     */
    private int aniosExperiencia;

    /**
     * The Constructor.
     *
     * @param rut              to use.
     * @param nombre           to use.
     * @param direccion        to use.
     * @param sueldoBase       to use.
     * @param aniosExperiencia to use.
     */
    public Analista(String rut, String nombre, String direccion, double sueldoBase, int aniosExperiencia) {
        super(rut, nombre, direccion, sueldoBase);
        // TODO: Check validacion
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * @return the AniosExperiencia.
     */
    public int getAniosExperiencia() {
        return this.aniosExperiencia;
    }

    /**
     * @return the sueldo of Funcionario.
     */
    @Override
    public double getSueldo() {
        double sueldo = this.getSueldoBase()
                + 5000 * this.aniosExperiencia;

        // Bono del 25% del valor mensual de cada proyecto
        for (Proyecto proyecto : this.getProyectos()) {
            if (proyecto != null) {
                sueldo += 0.25 * proyecto.getCosto();
            }
        }
        return sueldo;
    }
}
