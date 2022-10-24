/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft.utils;

import cl.ucn.disc.pa.mandiosoft.model.Proyecto;

/**
 * The Lista of Proyecto.
 *
 * @author Programacion Avanzada.
 */
public final class ListaProyecto {

    /**
     * The array of Proyecto.
     */
    private Proyecto[] proyectos;

    /**
     * Numero de proyectos.
     */
    private int size = 0;

    /**
     * The Constructor.
     *
     * @param capacidad to use.
     */
    public ListaProyecto(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad no valida: " + capacidad);
        }
        this.proyectos = new Proyecto[capacidad];
    }

    /**
     * @return how many Proyectos exists.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @param posicion to use.
     * @return the Proyecto.
     */
    public Proyecto getProyecto(int posicion) {
        // TODO: Check the value of posicion
        return this.proyectos[posicion];
    }

    /**
     * Retorna el Proyecto a partir de su codigo.
     *
     * @param codigo a buscar.
     * @return the Proyecto.
     */
    public Proyecto getProyectoPorCodigo(String codigo) {
        for (Proyecto proyecto : this.proyectos) {
            if (proyecto != null && proyecto.getCodigo().equals(codigo)) {
                return proyecto;
            }
        }
        return null;
    }

    /**
     * Agrega un Proyecto al final de la Lista.
     *
     * @param proyecto a agregar.
     */
    public void add(Proyecto proyecto) {
        // FIXME: Verificar capacidad!
        this.proyectos[this.size++] = proyecto;
    }
}
