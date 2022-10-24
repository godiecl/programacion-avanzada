/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft.model;

/**
 * The Funcionario.
 *
 * @author Programacion Avanzada.
 */
public abstract class Funcionario {

    /**
     * Capacidad maxima.
     */
    private final int MAX_PROYECTOS = 5;

    /**
     * The Rut.
     */
    private String rut;

    /**
     * The Nombre.
     */
    private String nombre;

    /**
     * The Direccion.
     */
    private String direccion;

    /**
     * The Sueldo base.
     */
    private double sueldoBase;

    /**
     * The Proyectos.
     */
    private Proyecto[] proyectos = new Proyecto[MAX_PROYECTOS];

    /**
     * The Constructor of Funcionario.
     *
     * @param rut        to use.
     * @param nombre     to use.
     * @param direccion  to use.
     * @param sueldoBase to use.
     */
    public Funcionario(String rut, String nombre, String direccion, double sueldoBase) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.sueldoBase = sueldoBase;
    }

    /**
     * @return the rut.
     */
    public String getRut() {
        return this.rut;
    }

    /**
     * @return the nombre.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return the direccion.
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * @return the sueldo base.
     */
    public double getSueldoBase() {
        return this.sueldoBase;
    }

    /**
     * @return the array of Proyectos.
     */
    public Proyecto[] getProyectos() {
        return this.proyectos;
    }

    /**
     * Asignar un proyecto.
     *
     * @param proyecto a asignar.
     */
    public void addProyecto(Proyecto proyecto) {
        for (int i = 0; i < MAX_PROYECTOS; i++) {
            if (this.proyectos[i] == null) {
                this.proyectos[i] = proyecto;
                return;
            }
        }
        throw new IllegalArgumentException("Maxima cantidad de proyectos ya asignados");
    }

    /**
     * @return the sueldo of Funcionario.
     */
    public abstract double getSueldo();
}
