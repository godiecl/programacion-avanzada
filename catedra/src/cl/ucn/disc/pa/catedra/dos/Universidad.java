/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.catedra.dos;

/**
 * The Universidad.
 *
 * @author Programacion Avanzada.
 */
public interface Universidad {

    /**
     * Agrega una nueva Sede a la Universidad, retorna false en caso que ya exista una sede con el mismo rut.
     *
     * @param sede a agregar.
     * @return true si fue posible su creacion.
     */
    boolean crearSede(Sede sede);

    /**
     * Agrega un Estudiante a una sede de la Universidad, retorna false si no es posible: porque el estudiante ya existe
     * en alguna Sede o porque la Sede no existe).
     *
     * @param estudiante a agregar.
     * @param rutSede    a la que se agrega.
     * @return true si fue posible agregarlo.
     */
    boolean agregarEstudianteSede(Estudiante estudiante, String rutSede);

    /**
     * Transfiere un Estudiante de una Sede a otra, retorna false si no es posible: el estudiante no existe o la sede
     * destino no existe.
     *
     * @param rutEstudiante  a transferir.
     * @param rutSedeOrigen  de donde se saca.
     * @param rutSedeDestino a donde se agrega.
     * @return true si fue posible transferirlo.
     */
    boolean transferirEstudianteDeSede(String rutEstudiante, String rutSedeOrigen, String rutSedeDestino);

    /**
     * Cierra una sede, los Estudiantes son reubicados en la sede más cercana.
     *
     * @param rutSede a cerrar.
     * @return true si fue posible cerrarla.
     */
    boolean cerrarSede(String rutSede);

    /**
     * Elimina un Estudiante de la Universidad no importando su Sede, retorna false si no es posible: el estudiante no
     * existe.
     *
     * @param rutEstudiante a eliminar.
     * @return true si fue posible eliminarlo.
     */
    boolean eliminarEstudiante(String rutEstudiante);

    /**
     * Retorna la cantidad total de Estudiantes que existen en la Universidad, es decir, la suma de todos los
     * estudiantes de las Sedes.
     *
     * @return la cantidad total de Estudiantes.
     */
    int cantidadDeEstudiantes();

}
