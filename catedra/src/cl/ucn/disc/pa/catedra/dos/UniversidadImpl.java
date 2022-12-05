/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.catedra.dos;

/**
 * Implementacion de la interface Universidad.
 *
 * @author Programacion Avanzada.
 */
public final class UniversidadImpl implements Universidad {

    /**
     * The Lista of Sede.
     */
    private final ListaSedeNexoDoble sedes;

    /**
     * The Constructor.
     */
    public UniversidadImpl() {
        sedes = new ListaSedeNexoDoble();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean crearSede(Sede sede) {
        // la sede ya existe, retorno null
        if (sedes.buscar(sede.getRut()) != null) {
            return false;
        }

        // agrega la sede a la lista de sedes
        return sedes.agregar(sede);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean agregarEstudianteSede(Estudiante estudiante, String rutSede) {

        // busca la sede
        Sede sede = sedes.buscar(rutSede);

        // la sede no existe, retorno null
        if (sede == null) {
            return false;
        }

        // agrega el estudiante a la sede
        return sede.agregarEstudiante(estudiante);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean transferirEstudianteDeSede(String rutEstudiante, String rutSedeOrigen, String rutSedeDestino) {

        // busca la sede origen
        Sede sedeOrigen = sedes.buscar(rutSedeOrigen);

        // la sede origen no existe, retorno false
        if (sedeOrigen == null) {
            return false;
        }

        // busca la sede destino
        Sede sedeDestino = sedes.buscar(rutSedeDestino);

        // la sede destino no existe, retorno false
        if (sedeDestino == null) {
            return false;
        }

        // busca el estudiante
        Estudiante estudiante = sedeOrigen.buscarEstudiante(rutEstudiante);

        // el estudiante no existe, retorno null
        if (estudiante == null) {
            return false;
        }

        // elimina el estudiante de la sede origen
        if (!sedeOrigen.eliminarEstudiante(rutEstudiante)) {
            return false;
        }

        // agrega el estudiante a la sede destino
        return sedeDestino.agregarEstudiante(estudiante);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cerrarSede(String rutSede) {

        // busca la sede
        Sede sedeEliminar = sedes.buscar(rutSede);
        if (sedeEliminar == null) {
            return false;
        }

        // busqueda de la sede mas cercana
        double menorDistancia = Double.MAX_VALUE;
        Sede sedeMasCercana = null;

        for (int i = 0; i < sedes.cantidadDeSedes(); i++) {
            Sede sedeLocal = sedes.getSede(i);

            // me debo saltar la sede que se quiere eliminar
            if (sedeLocal.getRut().equals(rutSede)) {
                continue;
            }

            // distancia entre la sede a eliminar y la sede local
            double distanciaEntreSedes = Math.abs(
                    Math.abs(sedeLocal.getDistancia()) - Math.abs(sedeEliminar.getDistancia())
            );
            if (sedeMasCercana == null || distanciaEntreSedes < menorDistancia) {
                sedeMasCercana = sedeLocal;
                menorDistancia = distanciaEntreSedes;
            }
        }

        // transferencia de estudiantes
        for (int i = 0; i < sedeMasCercana.cantidadDeEstudiantes(); i++) {
            Estudiante estudiante = sedeEliminar.getEstudiante(i);
            sedeMasCercana.agregarEstudiante(estudiante);
        }

        // eliminacion de la sede
        sedes.eliminar(sedeEliminar.getRut());
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean eliminarEstudiante(String rutEstudiante) {
        // busco la sede
        for (int i = 0; i < sedes.cantidadDeSedes(); i++) {
            // sede actual
            Sede sede = sedes.getSede(i);
            // buscar el estudiante en la sede
            Estudiante estudiante = sede.buscarEstudiante(rutEstudiante);
            // si lo encuentro ..
            if (estudiante != null) {
                // elimino el estudiante de la sede
                return sede.eliminarEstudiante(rutEstudiante);
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int cantidadDeEstudiantes() {
        // contador de los estudiantes
        int cantidadDeEstudiantes = 0;

        // sumo la cantidad de estudiantes de cada sede
        for (int i = 0; i < sedes.cantidadDeSedes(); i++) {
            cantidadDeEstudiantes += sedes.getSede(i).cantidadDeEstudiantes();
        }

        return cantidadDeEstudiantes;
    }

}
