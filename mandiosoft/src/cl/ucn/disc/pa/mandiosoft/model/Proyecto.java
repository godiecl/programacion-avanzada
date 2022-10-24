/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft.model;

/**
 * The Proyecto.
 *
 * @author Programacion Avanzada.
 */
public final class Proyecto {

    /**
     * The Codigo.
     */
    private String codigo;

    /**
     * The Nombre.
     */
    private String nombre;

    /**
     * The Duracion.
     */
    private int duracionMeses;

    /**
     * The Costo.
     */
    private double costo;

    /**
     * The Programador.
     */
    private Programador programador;

    /**
     * The Analista.
     */
    private Analista analista;

    /**
     * The Ingeniero.
     */
    private Ingeniero ingeniero;

    /**
     * The Constructor.
     *
     * @param codigo        to use.
     * @param nombre        to use.
     * @param duracionMeses to use.
     */
    public Proyecto(String codigo, String nombre, int duracionMeses, double costo) {
        // TODO: Agregar validacion
        this.codigo = codigo;
        // TODO: Agregar validacion
        this.nombre = nombre;
        // TODO: Agregar validacion
        this.duracionMeses = duracionMeses;
        // TODO: Agregar validacion
        this.costo = costo;
    }

    /**
     * @return the CostoTotal.
     */
    public double getCostoMensual() {
        double total = 0.0;
        if (this.programador != null) {
            total += this.programador.getSueldo();
        }
        if (this.analista != null) {
            total += this.analista.getSueldo();
        }
        if (this.ingeniero != null) {
            total += this.ingeniero.getSueldo();
        }
        return total;
    }

    /**
     * @return the Codigo.
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * @return the Nombre.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return the Duracion.
     */
    public int getDuracionMeses() {
        return this.duracionMeses;
    }

    /**
     * @return costo del proyecto.
     */
    public double getCosto() {
        return this.costo;
    }

    /**
     * @return the Programador.
     */
    public Programador getProgramador() {
        return this.programador;
    }

    /**
     * @return the Analista.
     */
    public Analista getAnalista() {
        return this.analista;
    }

    /**
     * @return the Ingeniero.
     */
    public Ingeniero getIngeniero() {
        return this.ingeniero;
    }

    /**
     * Set the Programador.
     *
     * @param programador a agregar.
     */
    public void setProgramador(Programador programador) {
        this.programador = programador;
    }

    /**
     * Set the Analista.
     *
     * @param analista a agregar.
     */
    public void setAnalista(Analista analista) {
        this.analista = analista;
    }

    /**
     * Set the Ingeniero.
     *
     * @param ingeniero a agregar.
     */
    public void setIngeniero(Ingeniero ingeniero) {
        this.ingeniero = ingeniero;
    }
}
