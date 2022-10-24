/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft.utils;

import cl.ucn.disc.pa.mandiosoft.model.Funcionario;

/**
 * The Lista of Funcionario.
 *
 * @author Programacion Avanzada.
 */
public final class ListaFuncionario {

    /**
     * The array of Funcionario.
     */
    private Funcionario[] funcionarios;

    /**
     * Numero de proyectos.
     */
    private int size = 0;

    /**
     * The Constructor.
     *
     * @param capacidad to use.
     */
    public ListaFuncionario(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad no valida: " + capacidad);
        }
        this.funcionarios = new Funcionario[capacidad];
    }

    /**
     * @return how many Funcionarios exists.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @param posicion to use.
     * @return the Funcionario.
     */
    public Funcionario getFuncionario(int posicion) {
        // TODO: Check the value of posicion
        return this.funcionarios[posicion];
    }

    /**
     * @param rut a buscar.
     * @return the Funcionario.
     */
    public Funcionario getFuncionarioPorRut(String rut) {
        for (Funcionario funcionario : this.funcionarios) {
            if (funcionario != null && funcionario.getRut().equals(rut)) {
                return funcionario;
            }
        }
        return null;
    }

    /**
     * Agrega un funcionario a la Lista.
     *
     * @param funcionario a agregar.
     */
    public void add(Funcionario funcionario) {
        this.funcionarios[this.size++] = funcionario;
    }
}
