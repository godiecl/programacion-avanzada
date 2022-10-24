/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.mandiosoft.services;

import cl.ucn.disc.pa.mandiosoft.model.Analista;
import cl.ucn.disc.pa.mandiosoft.model.Funcionario;
import cl.ucn.disc.pa.mandiosoft.model.Ingeniero;
import cl.ucn.disc.pa.mandiosoft.model.Programador;
import cl.ucn.disc.pa.mandiosoft.model.Proyecto;
import cl.ucn.disc.pa.mandiosoft.utils.ListaFuncionario;
import cl.ucn.disc.pa.mandiosoft.utils.ListaProyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The implementation of operaciones de sistema.
 *
 * @author Programacion Avanzada.
 */
public final class SistemaImpl implements Sistema {

    /**
     * The List of Proyecto.
     */
    private ListaProyecto proyectos;

    /**
     * The List of Funcionario.
     */
    private ListaFuncionario funcionarios;

    /**
     * The Constructor.
     */
    public SistemaImpl(String rootPath) {
        this.proyectos = new ListaProyecto(100);
        this.funcionarios = new ListaFuncionario(500);

        // directorio con los datos
        String dataPath = rootPath + File.separator + "data" + File.separator;

        // carga de los distintos archivos
        this.cargarProyectos(dataPath + "mandiosoft_proyectos.dat");
        this.cargarFuncionarios(dataPath + "mandiosoft_funcionarios.dat");
        this.cargaAsignacionFuncionariosProyectos(dataPath + "mandiosoft_proyectos_funcionarios.dat");
    }

    /**
     * Carga de Proyectos.
     */
    private void cargarProyectos(String path) {

        System.out.println("Cargando Proyectos ..");
        try {
            Scanner in = new Scanner(new File(path));

            int nLine = 0;
            while (in.hasNextLine()) {
                nLine++;
                String line = in.nextLine();
                System.out.printf("Reading line %d : %s%n", nLine, line);

                String[] array = line.split(",");
                if (array.length != 4) {
                    System.out.println("Skipping wrong line: " + line);
                    continue;
                }

                Proyecto proyecto = new Proyecto(
                        array[0],
                        array[1],
                        Integer.parseInt(array[2]),
                        Double.parseDouble(array[3])
                );
                this.proyectos.add(proyecto);
            }

            System.out.printf(".. %d Proyectos Cargados!%n", this.proyectos.getSize());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carga de funcionarios.
     */
    private void cargarFuncionarios(String path) {
        System.out.println("Cargando Funcionarios ..");
        try {
            Scanner in = new Scanner(new File(path));

            // Contador de lineas
            int nLine = 0;
            while (in.hasNextLine()) {
                nLine++;

                // Lectura de la linea desde del archivo
                String line = in.nextLine();
                System.out.printf("Reading line %d : %s%n", nLine, line);

                // Separo los tokens del funcionario por coma
                String[] array = line.split(",");

                // Cuento el numero de tokens y de acuerdo a ellos instancio un funcionario
                switch (array.length) {
                    // Analista
                    case 5:
                        Analista analista = new Analista(
                                array[0], // rut
                                array[1], // nombre
                                array[2], // direccion
                                Double.parseDouble(array[3]), // sueldobase
                                Integer.parseInt(array[4]) // anios experiencia
                        );
                        this.funcionarios.add(analista);
                        break;
                    // Ingeniero
                    case 6:
                        Ingeniero ingeniero = new Ingeniero(
                                array[0], // rut
                                array[1], // nombre
                                array[2], // direccion
                                Double.parseDouble(array[3]), // sueldobase
                                array[4], // titulo
                                Integer.parseInt(array[5]) // cargas familiares
                        );
                        this.funcionarios.add(ingeniero);
                        break;
                    // Programador
                    case 7:
                        Programador programador = new Programador(
                                array[0], // rut
                                array[1], // nombre
                                array[2], // direccion
                                Double.parseDouble(array[3]), // sueldobase
                                array[4], // lenguaje de programacion
                                Integer.parseInt(array[5]), // horas extras
                                Integer.parseInt(array[6]) // nivel programador
                        );
                        this.funcionarios.add(programador);
                        break;
                    // En caso de cualquier otro caso
                    default: {
                        System.out.println("Skipping wrong line: " + line);
                        continue;
                    }
                }
            }

            System.out.printf(".. %d Funcionarios Cargados!%n", this.proyectos.getSize());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carga la asociacion entre Proyecto y Funcionario.
     */
    private void cargaAsignacionFuncionariosProyectos(String path) {
        System.out.println("Asociando Proyectos a Funcionarios..");
        try {
            Scanner in = new Scanner(new File(path));

            int nLine = 0;
            int nAsoc = 0;
            while (in.hasNextLine()) {
                nLine++;
                String line = in.nextLine();
                System.out.printf("Reading line %d : %s%n", nLine, line);

                String[] array = line.split(",");
                if (array.length != 2) {
                    System.out.println("Skipping wrong line: " + line);
                    continue;
                }

                String codigoProyecto = array[0];
                String rutFuncionario = array[1];

                Proyecto proyecto = this.proyectos.getProyectoPorCodigo(codigoProyecto);
                Funcionario funcionario = this.funcionarios.getFuncionarioPorRut(rutFuncionario);

                // Validacion de busqueda
                if (proyecto == null || funcionario == null) {
                    System.out.println("Proyecto/Funcionario not found, skipping ..");
                    continue;
                }

                // Validacion de tipo
                if (funcionario instanceof Programador) {
                    proyecto.setProgramador((Programador) funcionario);
                    funcionario.addProyecto(proyecto);
                } else {
                    if (funcionario instanceof Analista) {
                        proyecto.setAnalista((Analista) funcionario);
                        funcionario.addProyecto(proyecto);
                    } else {
                        if (funcionario instanceof Ingeniero) {
                            proyecto.setIngeniero((Ingeniero) funcionario);
                            funcionario.addProyecto(proyecto);
                        } else {
                            System.out.println("Tipo no valido!, skipping..");
                        }
                    }
                }
                nAsoc++;

            }

            System.out.printf(".. %d Asociaciones Cargadas!%n", nAsoc);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Listado de Proyectos con los costos involucrados (por meses y total).
     */
    @Override
    public String getProyectosConCostos() {
        // unidor de string
        StringBuilder sb = new StringBuilder();

        sb.append("Proyectos en Mandiosoft\n");
        sb.append("=======================================================================================\n");
        // recorro los proyectos
        for (int i = 0; i < this.proyectos.getSize(); i++) {
            Proyecto proyecto = this.proyectos.getProyecto(i);
            sb.append("Proyecto        : ").append(proyecto.getNombre()).append("\n");
            sb.append("- duracion      : ").append(proyecto.getDuracionMeses()).append("\n");
            sb.append("- costo mensual : ").append(proyecto.getCostoMensual()).append("\n");
            sb.append("- costo total   : ").append(proyecto.getDuracionMeses() * proyecto.getCostoMensual()).append("\n");
            sb.append("=======================================================================================\n");
        }

        // retorno el string
        return sb.toString();
    }

    /**
     * Listado de funcionarios con sus respectivos sueldos. No es necesario desplegar los proyectos en los que
     * participa.
     */
    @Override
    public String getListadoFuncionariosConSueldo() {
        // unidor de string
        StringBuilder sb = new StringBuilder();

        sb.append("Funcionarios en Mandiosoft\n");
        sb.append("=======================================================================================\n");
        // recorro todos los funcionarios
        for (int i = 0; i < this.funcionarios.getSize(); i++) {
            Funcionario funcionario = this.funcionarios.getFuncionario(i);
            sb.append("Funcionario   : ").append(funcionario.getNombre()).append("\n");
            sb.append("- direccion   : ").append(funcionario.getDireccion()).append("\n");
            sb.append("- sueldo base : ").append(funcionario.getSueldoBase()).append("\n");
            sb.append("- sueldo      : ").append(funcionario.getSueldo()).append("\n");
            sb.append("- tipo        : ");
            if (funcionario instanceof Ingeniero) {
                sb.append("Ingeniero");
            } else {
                if (funcionario instanceof Analista) {
                    sb.append("Analista");
                } else {
                    if (funcionario instanceof Programador) {
                        sb.append("Programador");
                    } else {
                        sb.append("Tipo desconocido!");
                    }
                }
            }
            sb.append("\n");
            sb.append("=======================================================================================\n");
        }

        return sb.toString();
    }

    /**
     * Dado un proyecto entregar el listado de gente involucrada.
     *
     * @param codigoProyecto a desplegar.
     */
    @Override
    public String getFuncionarios(String codigoProyecto) {
        Proyecto proyecto = this.proyectos.getProyectoPorCodigo(codigoProyecto);
        if (proyecto == null) {
            return "No se encontro proyecto: " + codigoProyecto;
        }

        // unidor de string
        StringBuilder sb = new StringBuilder();
        sb.append("Funcionarios de Mandiosoft en Proyecto").append(codigoProyecto).append("\n");
        sb.append("=======================================================================================\n");

        Ingeniero ingeniero = proyecto.getIngeniero();
        if (ingeniero != null) {
            sb.append("Ingeniero     : ").append(ingeniero.getNombre()).append("\n");
            sb.append("- direccion   : ").append(ingeniero.getDireccion()).append("\n");
            sb.append("- sueldo base : ").append(ingeniero.getSueldoBase()).append("\n");
            sb.append("- sueldo      : ").append(ingeniero.getSueldo()).append("\n");
            sb.append("=======================================================================================\n");
        }

        Analista analista = proyecto.getAnalista();
        if (analista != null) {
            sb.append("Analista      : ").append(analista.getNombre()).append("\n");
            sb.append("- direccion   : ").append(analista.getDireccion()).append("\n");
            sb.append("- sueldo base : ").append(analista.getSueldoBase()).append("\n");
            sb.append("- sueldo      : ").append(analista.getSueldo()).append("\n");
            sb.append("=======================================================================================\n");
        }

        Programador programador = proyecto.getProgramador();
        if (programador != null) {
            sb.append("Programador   : ").append(programador.getNombre()).append("\n");
            sb.append("- direccion   : ").append(programador.getDireccion()).append("\n");
            sb.append("- sueldo base : ").append(programador.getSueldoBase()).append("\n");
            sb.append("- sueldo      : ").append(programador.getSueldo()).append("\n");
            sb.append("=======================================================================================\n");
        }

        return sb.toString();
    }

    /**
     * Dado un proyecto entregar el listado de gente involucrada.
     *
     * @param rut del Funcionario a buscar.
     */
    @Override
    public String getProyectos(String rut) {
        Funcionario funcionario = this.funcionarios.getFuncionarioPorRut(rut);
        if (funcionario == null) {
            return "No se encontro el Funcionario con rut: " + rut;
        }

        // unidor de string
        StringBuilder sb = new StringBuilder();
        sb.append("Proyectos Asociados al Funcionario: ").append(funcionario.getNombre()).append("\n");
        sb.append("=======================================================================================\n");

        for (Proyecto proyecto : funcionario.getProyectos()) {
            if (proyecto != null) {
                sb.append("Proyecto: ").append(proyecto.getNombre()).append("\n");
            }
        }
        sb.append("=======================================================================================\n");

        return sb.toString();
    }

    /**
     * Para cada funcionario ingeniero, su nombre y su título.
     */
    @Override
    public String getIngenieros() {
        // unidor de string
        StringBuilder sb = new StringBuilder();
        boolean exists = false;
        for (int i = 0; i < this.funcionarios.getSize(); i++) {
            Funcionario funcionario = this.funcionarios.getFuncionario(i);
            if (funcionario instanceof Ingeniero) {
                sb.append("Ingeniero : ").append(funcionario.getNombre());
                sb.append("Titulo    : ").append(((Ingeniero) funcionario).getTitulo()).append("\n");
                exists = true;
            }
        }
        if (!exists) {
            sb.append("No hay ingenieros en Mandiosoft.");
        }
        return sb.toString();
    }

}
