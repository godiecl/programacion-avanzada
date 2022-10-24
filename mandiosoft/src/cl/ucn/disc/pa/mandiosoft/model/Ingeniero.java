/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft.model;

/**
 * The Ingeniero.
 *
 * @author Programacion Avanzada.
 */
public final class Ingeniero extends Funcionario {

    /**
     * The Titulo.
     */
    private String titulo;

    /**
     * Cantidad de Cargas Familiares.
     */
    private int cantidadCargasFamiliares;

    /**
     * The Constructor.
     *
     * @param rut                      to use.
     * @param nombre                   to use.
     * @param direccion                to use.
     * @param sueldoBase               to use.
     * @param titulo                   to use.
     * @param cantidadCargasFamiliares to use.
     */
    public Ingeniero(String rut, String nombre, String direccion, double sueldoBase, String titulo, int cantidadCargasFamiliares) {
        super(rut, nombre, direccion, sueldoBase);
        // TODO: Agregar validacion
        this.titulo = titulo;
        // TODO: Agregar validacion
        this.cantidadCargasFamiliares = cantidadCargasFamiliares;
    }

    /**
     * @return the Titulo.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * @return the CantidadCargasFamiliares.
     */
    public int getCantidadCargasFamiliares() {
        return this.cantidadCargasFamiliares;
    }

    /**
     * @return the sueldo of Funcionario.
     */
    @Override
    public double getSueldo() {
        double sueldo = this.getSueldoBase()
                + 8000 * this.getCantidadCargasFamiliares();
        // Bono del 30% del valor mensual de cada proyecto
        for (Proyecto proyecto : this.getProyectos()) {
            if (proyecto != null) {
                sueldo += 0.3 * proyecto.getCosto();
            }
        }
        return sueldo;
    }
}
