/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.listaenlazada.model;

import cl.ucn.disc.pa.listaenlazada.colecciones.Elemento;

/**
 * The Vehiculo.
 *
 * @author Programacion Avanzada.
 */
public final class Vehiculo implements Elemento {

    /**
     * La placa patente.
     */
    private final String placa;

    /**
     * El modelo.
     */
    private final String modelo;

    /**
     * La marca.
     */
    private final String marca;

    /**
     * Constructor de Vehiculo.
     *
     * @param placa  a usar.
     * @param modelo a usar.
     * @param marca  a usar.
     */
    public Vehiculo(String placa, String modelo, String marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
    }

    /**
     * @return the Placa.
     */
    public String getPlaca() {
        return this.placa;
    }

    /**
     * @return the Modelo.
     */
    public String getModelo() {
        return this.modelo;
    }

    /**
     * @return the Marca.
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * Realiza la comparacion entre dos Elementos.
     *
     * @param e elemento a comparar.
     * @return true si ambos elementos son iguales.
     */
    @Override
    public boolean esIgual(Elemento e) {

        // comparacion conmigo mismo
        if (this == e) {
            return true;
        }

        // Si e es la misma instancia, es igual
        if (e instanceof Vehiculo vehiculo) {
            return this.placa.equals(vehiculo.placa);
        }
        return false;
    }

    /**
     * Realiza la comparacion de tamanio entre dos Elementos.
     *
     * @param e elemento a comparar.
     * @return 0 si son iguales, -1 is es menor, 1 si es mayor.
     */
    @Override
    public int compararCon(Elemento e) {
        // comparacion conmigo mismo
        if (this == e) {
            return 0;
        }

        // comparacion por placa
        if (e instanceof Vehiculo vehiculo) {
            return this.placa.compareTo(vehiculo.placa);
        }

        // no se puede comparar
        throw new IllegalArgumentException("Elemento no es un Vehiculo");
    }
}
