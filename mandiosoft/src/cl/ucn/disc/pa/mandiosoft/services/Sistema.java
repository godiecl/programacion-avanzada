/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft.services;

/**
 * The Operaciones de Sistema.
 *
 * @author Programacion Avanzada.
 */
public interface Sistema {

    /**
     * Listado de Proyectos con los costos involucrados (por meses y total).
     */
    String getProyectosConCostos();

    /**
     * Listado de funcionarios con sus respectivos sueldos. No es necesario desplegar los proyectos en los que
     * participa.
     */
    String getListadoFuncionariosConSueldo();

    /**
     * Dado un proyecto entregar el listado de gente involucrada.
     */
    String getFuncionarios(String codigoProyecto);

    /**
     * Dado un proyecto entregar el listado de gente involucrada.
     */
    String getProyectos(String rut);

    /**
     * Para cada funcionario ingeniero, su nombre y su título.
     */
    String getIngenieros();

}
