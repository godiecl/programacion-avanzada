/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.catedra.tres.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Palabra.
 *
 * @author Programacion Avanzada.
 */
public final class Palabra {

    /**
     * La palabra.
     */
    private String palabra;

    /**
     * Sus significados.
     */
    private List<String> significados = new ArrayList<>();

    /**
     * Las lineas donde aparece.
     */
    private List<Integer> lineas = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param palabra a utilizar.
     */
    public Palabra(String palabra) {
        this.palabra = palabra.toLowerCase();
    }

    /**
     * @return the palabra.
     */
    public String getPalabra() {
        return this.palabra;
    }

    /**
     * Agrega la linea donde se encuentra la palabra.
     *
     * @param linea a agregar.
     */
    public void addLinea(int linea) {
        if (linea <= 0) {
            throw new IllegalArgumentException("No se permite linea <= 0");
        }
        this.lineas.add(linea);
    }

    /**
     * Agrega un significado a la palabra.
     *
     * @param significado a agregar.
     */
    public void addSignificado(String significado) {
        this.significados.add(significado);
    }

    /**
     * Numero de lineas donde aparece la palabra.
     *
     * @return the integer.
     */
    public int getLineas() {
        return this.lineas.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.palabra).append(": ");
        for (int linea : this.lineas) {
            str.append(linea).append(" ");
        }
        return str.toString();
    }
}
