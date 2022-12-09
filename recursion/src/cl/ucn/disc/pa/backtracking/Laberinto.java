/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.backtracking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * The Laberinto: Resuelve el recorrido de un laberinto en formato ASCII:
 *
 * <pre>
 * ###################################S#
 * # #       #       #     #         # #
 * # # ##### # ### ##### ### ### ### # #
 * #       #   # #     #     # # #   # #
 * ##### # ##### ##### ### # # # ##### #
 * #   # #       #     # # # # #     # #
 * # # ####### # # ##### ### # ##### # #
 * # #       # # #   #     #     #   # #
 * # ####### ### ### # ### ##### # ### #
 * #     #   # #   # #   #     # #     #
 * # ### ### # ### # ##### # # # #######
 * #   #   # # #   #   #   # # #   #   #
 * ####### # # # ##### # ### # ### ### #
 * #     # #     #   # #   # #   #     #
 * # ### # ##### ### # ### ### ####### #
 * # #   #     #     #   # # #       # #
 * # # ##### # ### ##### # # ####### # #
 * # #     # # # # #     #       # #   #
 * # ##### # # # ### ##### ##### # #####
 * # #   # # #     #     # #   #       #
 * # # ### ### ### ##### ### # ##### # #
 * # #         #     #       #       # #
 * #E###################################
 * </pre>
 *
 * @author Programacion Avanzada.
 */
public final class Laberinto {

    /**
     * Definicion de cada casilla.
     */
    private static final char PARED = '#';
    private static final char LIBRE = ' ';
    private static final char SALIDA = 'S';
    private static final char ENTRADA = 'E';
    private static final char CAMINO = '*';

    /**
     * La matriz donde se encuentra el laberinto
     */
    private final char[][] laberinto;

    /**
     * Constructor del laberinto.
     *
     * @param laberinto to use.
     */
    public Laberinto(final char[][] laberinto) {
        this.laberinto = laberinto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int f = 0; f < this.laberinto.length; f++) {
            for (int c = 0; c < this.laberinto[f].length; c++) {
                sb.append(this.laberinto[f][c]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Intenta buscar la salida del laberinto.
     *
     * @return true si fue posible encontrar posicion.
     */
    public boolean buscarSalida() {
        int filaInicio = -1;
        int columnaInicio = -1;
        for (int f = 0; f < this.laberinto.length; f++) {
            for (int c = 0; c < this.laberinto[f].length; c++) {
                if (this.laberinto[f][c] == ENTRADA) {
                    filaInicio = f;
                    columnaInicio = c;
                }
            }
        }
        // validacion
        if (filaInicio == -1 || columnaInicio == -1) {
            throw new RuntimeException("No se encontro la entrada");
        }
        return this.buscarSalida(filaInicio, columnaInicio);

    }

    /**
     * Intenta buscar la salida del laberinto.
     *
     * @param fila    de inicio.
     * @param columna de inicio.
     * @return true si se encontro la salida.
     */
    private boolean buscarSalida(final int fila, final int columna) {

        // impresion del laberinto
        System.out.println(this);

        // movimientos
        int[] movimientoFila = {-1, 0, 1, 0};
        int[] movimientoColumna = {0, 1, 0, -1};

        // ciclo de movimientos
        for (int i = 0; i < movimientoFila.length; i++) {

            // nuevo candidato
            int nuevaFila = fila + movimientoFila[i];
            int nuevaColumna = columna + movimientoColumna[i];

            // si es valido el movimiento
            if (this.isAceptable(nuevaFila, nuevaColumna)) {

                // podria haber llegado a la salida
                if (this.laberinto[nuevaFila][nuevaColumna] == SALIDA) {
                    return true;
                }

                // marcamos el camino
                this.laberinto[nuevaFila][nuevaColumna] = CAMINO;

                // intentamos con el nuevo movimiento
                if (!this.buscarSalida(nuevaFila, nuevaColumna)) {
                    this.laberinto[nuevaFila][nuevaColumna] = LIBRE;
                } else {
                    return true;
                }
            }
        }
        // no encontre solucion
        return false;
    }

    /**
     * Es aceptable el movimiento?
     *
     * @param fila    a donde me quiero mover.
     * @param columna a donde me quiero mover.
     * @return true si el movimiento es valido.
     */
    private boolean isAceptable(final int fila, final int columna) {
        // me sali de la filas
        if (fila < 0 || fila >= this.laberinto.length) {
            return false;
        }
        // me sali de las columnas
        if (columna < 0 || columna >= this.laberinto[fila].length) {
            return false;
        }
        // solo si esta libre
        return this.laberinto[fila][columna] == LIBRE || this.laberinto[fila][columna] == SALIDA;
    }

    /**
     * The Main.
     */
    public static void main(String[] args) throws IOException {

        // lectura del archivo
        List<String> lines = Files.readAllLines(Paths.get("recursion\\laberinto.txt"));

        // tamanio del laberinto
        int filas = lines.size();
        int columnas = lines.get(0).length();

        // creacion de la matriz
        char[][] laberinto = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            String line = lines.get(i);
            for (int j = 0; j < columnas; j++) {
                laberinto[i][j] = line.charAt(j);
            }
        }

        // creacion del objeto laberinto
        Laberinto lab = new Laberinto(laberinto);
        System.out.println("Laberinto inicial:");
        System.out.println(lab);

        // busqueda de la salida
        System.out.println("Buscando salida ..");
        if (lab.buscarSalida()) {
            System.out.println("Salida encontrada :)");
            System.out.println(lab);
        } else {
            System.out.println("No se encontro salida !!");
        }

    }

}
