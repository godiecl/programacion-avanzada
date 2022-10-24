/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft.model;

/**
 * The Programador.
 *
 * @author Programacion Avanzada.
 */
public final class Programador extends Funcionario {

    /**
     * The Lenguaje de Programacion.
     */
    private String lenguajeProgramacion;

    /**
     * Horas Extras.
     */
    private int horasExtras;

    /**
     * Nivel del Programador.
     */
    private int nivelProgramador;

    /**
     * The Constructor.
     *
     * @param rut                  to use.
     * @param nombre               to use.
     * @param direccion            to use.
     * @param sueldoBase           to use.
     * @param lenguajeProgramacion to use.
     * @param horasExtras          to use.
     * @param nivelProgramador     to use.
     */
    public Programador(String rut, String nombre, String direccion, double sueldoBase, String lenguajeProgramacion, int horasExtras, int nivelProgramador) {
        super(rut, nombre, direccion, sueldoBase);
        // TODO: Agregar validacion
        this.lenguajeProgramacion = lenguajeProgramacion;
        // TODO: Agregar validacion
        this.horasExtras = horasExtras;
        // TODO: Agregar validacion
        this.nivelProgramador = nivelProgramador;
    }

    /**
     * @return the sueldo of Funcionario.
     */
    @Override
    public double getSueldo() {

        double sueldo = this.getSueldoBase()
                // $5000 por cada hora extra
                + 5000 * this.horasExtras
                // $30000 por el nivel que tenga
                + 30000 * this.nivelProgramador;

        // Bono del 20% del valor mensual de cada proyecto
        for (Proyecto proyecto : this.getProyectos()) {
            if (proyecto != null) {
                sueldo += 0.2 * proyecto.getCosto();
            }
        }
        return sueldo;
    }

    /**
     * @return the LenguajeProgramacion.
     */
    public String getLenguajeProgramacion() {
        return this.lenguajeProgramacion;
    }

    /**
     * @return the HorasExtras.
     */
    public int getHorasExtras() {
        return this.horasExtras;
    }

    /**
     * @return the NivelProgramador.
     */
    public int getNivelProgramador() {
        return this.nivelProgramador;
    }
}
