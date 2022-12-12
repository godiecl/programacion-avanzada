/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The Solitario.
 *
 * @author Programacion Avanzada.
 */
public final class ElSolitario {

    /**
     * the tablero.
     */
    private final char[][] tablero = new char[8][8];

    /**
     * valores validos en el tablero.
     */
    private static final char FICHA = '.';
    private static final char VACIO = 'O';
    private static final char FUERA = 'X';

    /**
     * the lista of movimientos.
     */
    private final List<String> movimientos = new ArrayList<>();

    /**
     * the numero de intentos
     */
    private long intentos = 0;

    /**
     * Constructor del Solitario: llena el tablero de fichas.
     */
    public ElSolitario() {

        // llenado del tablero de fichas
        for (int f = 7; f >= 1; f--) {
            for (int c = 1; c <= 7; c++) {
                this.tablero[f][c] = FICHA;
            }
        }

        // posicion central vacia
        this.tablero[4][4] = VACIO;

        // fila y columna cero no son parte del tablero
        for (int i = 0; i < this.tablero.length; i++) {
            this.tablero[0][i] = FUERA;
            this.tablero[i][0] = FUERA;
        }

        // cuatro esquinas
        this.tablero[1][1] = FUERA;
        this.tablero[1][2] = FUERA;
        this.tablero[2][1] = FUERA;
        this.tablero[2][2] = FUERA;

        this.tablero[1][7] = FUERA;
        this.tablero[2][7] = FUERA;
        this.tablero[1][6] = FUERA;
        this.tablero[2][6] = FUERA;

        this.tablero[6][7] = FUERA;
        this.tablero[6][6] = FUERA;
        this.tablero[7][7] = FUERA;
        this.tablero[7][6] = FUERA;

        this.tablero[6][2] = FUERA;
        this.tablero[6][1] = FUERA;
        this.tablero[7][2] = FUERA;
        this.tablero[7][1] = FUERA;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int c = 1; c <= 7; c++) {
            sb.append(c).append(" ");
        }
        sb.append("\n");
        for (int f = 7; f >= 1; f--) {
            sb.append(f).append(" ");
            for (int c = 1; c <= 7; c++) {
                sb.append(this.tablero[f][c]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Metodo recursivo que busca solucion.
     *
     * @return true si encontre solucion.
     */
    @SuppressWarnings("checkstyle:MissingSwitchDefault")
    public boolean buscarSolucion() {

        // llegue a la solucion?
        if (this.isSolucion()) {
            return true;
        }

        // arreglo de movimientos
        final int[] movimientoFila = {2, 0, -2, 0};
        final int[] movimientoColumna = {0, 2, 0, -2};

        // generacion de candidatos: todas las posibles del tablero
        for (int fila = 1; fila <= 7; fila++) {
            for (int columna = 1; columna <= 7; columna++) {

                // ciclo para generar las posiciones destino
                for (Movimiento movimiento : Movimiento.values()) {

                    // contador de intentos
                    this.intentos++;

                    // es aceptable mover una ficha desde (fila, columna) en una direccion
                    if (this.isAceptable(fila, columna, movimiento)) {

                        this.marcar(fila, columna, movimiento, true);

                        if (!this.buscarSolucion()) {
                            this.marcar(fila, columna, movimiento, false);
                        } else {
                            return true;
                        }

                    }

                }

            }

        }

        // por aca no encontre solucion
        return false;

    }

    /**
     * A partir de la (fila, columna) mueve la ficha eliminando la intermedia.
     *
     * @param fila       origen.
     * @param columna    origen.
     * @param movimiento hacia donde muevo la ficha.
     * @param marcar     true si marca, false si desmarca.
     */
    @SuppressWarnings("checkstyle:MissingSwitchDefault")
    private void marcar(int fila, int columna, Movimiento movimiento, boolean marcar) {

        // valor al mover la ficha
        char mover = marcar ? VACIO : FICHA;
        // valor al regresar la ficha
        char desMover = marcar ? FICHA : VACIO;

        // saco la ficha de la posicion origen
        this.tablero[fila][columna] = mover;

        // remuevo la ficha del tablero que se comio
        switch (movimiento) {
            case ARRIBA -> this.tablero[fila + 1][columna] = mover;
            case DERECHA -> this.tablero[fila][columna + 1] = mover;
            case ABAJO -> this.tablero[fila - 1][columna] = mover;
            case IZQUIERDA -> this.tablero[fila][columna - 1] = mover;
        }

        // calculo de la posicion de destino
        int filaDestino = fila;
        int columnaDestino = columna;

        // calculo del movimiento
        switch (movimiento) {
            case ARRIBA -> filaDestino += 2;
            case DERECHA -> columnaDestino += 2;
            case ABAJO -> filaDestino += -2;
            case IZQUIERDA -> columnaDestino += -2;
        }

        // coloco la ficha en su posicion destino
        this.tablero[filaDestino][columnaDestino] = desMover;

        // agregar o remover el movimiento
        if (marcar) {
            this.movimientos.add(columna + "" + fila + "" + columnaDestino + "" + filaDestino);
        } else {
            this.movimientos.remove(this.movimientos.size() - 1);
        }
    }

    /**
     * Verifica si el tablero llego a la solucion.
     *
     * @return true si el tablero tiene solucion.
     */
    private boolean isSolucion() {
        // contador de fichas
        int sumaFichas = 0;
        for (int fila = 1; fila <= 7; fila++) {
            for (int columna = 1; columna <= 7; columna++) {
                if (this.tablero[fila][columna] == FICHA) {
                    sumaFichas++;
                }
            }
        }
        // si no hay solo 1 ficha
        if (sumaFichas != 1) {
            return false;
        }

        // debe estar en la posicion 4,4
        return this.tablero[4][4] == FICHA;
    }

    /**
     * Verifica si desde una filaOrigen, columnaOrigen se puede mover una ficha en direccion del movimiento.
     *
     * @param filaOrigen    posicion en fila.
     * @param columnaOrigen posicion en columna.
     * @param movimiento    a realizar.
     * @return true si es posible.
     */
    private boolean isAceptable(final int filaOrigen, final int columnaOrigen, final Movimiento movimiento) {

        // posicion inicial fuera del tablero
        if (filaOrigen < 1 || filaOrigen > 7 || columnaOrigen < 1 || columnaOrigen > 7) {
            return false;
        }

        // posicion inicial no hay ficha
        if (this.tablero[filaOrigen][columnaOrigen] != FICHA) {
            return false;
        }

        // posicion destino del movimiento
        int filaDestino = filaOrigen;
        int columnaDestino = columnaOrigen;

        // calculo del movimiento
        switch (movimiento) {
            case ARRIBA -> filaDestino += 2;
            case DERECHA -> columnaDestino += 2;
            case ABAJO -> filaDestino += -2;
            case IZQUIERDA -> columnaDestino += -2;
        }

        // posicion final fuera del tablero
        if (filaDestino < 1 || filaDestino > 7 || columnaDestino < 1 || columnaDestino > 7) {
            return false;
        }

        // posicion destino no es un espacio
        if (this.tablero[filaDestino][columnaDestino] != VACIO) {
            return false;
        }

        // verificacion de pin entre la posicion de origen y la destino
        switch (movimiento) {
            case ARRIBA -> {
                return this.tablero[filaOrigen + 1][columnaOrigen] == FICHA;
            }
            case DERECHA -> {
                return this.tablero[filaOrigen][columnaOrigen + 1] == FICHA;
            }
            case ABAJO -> {
                return this.tablero[filaOrigen - 1][columnaOrigen] == FICHA;
            }
            case IZQUIERDA -> {
                return this.tablero[filaOrigen][columnaOrigen - 1] == FICHA;
            }
        }
        return false;

    }

    /**
     * The Main.
     */
    public static void main(String[] args) {
        // el juego del solitario
        ElSolitario solitario = new ElSolitario();

        // imprimir su representacion
        System.out.println("Tablero inicial:");
        System.out.println(solitario.toString());

        System.out.println("Buscando solucion, por favor espere ..");
        long millis = System.currentTimeMillis();

        if (solitario.buscarSolucion()) {
            System.out.printf("Solucion encontrada en %,d ms. con %s movimientos y %,d intentos.\n",
                    (System.currentTimeMillis() - millis),
                    solitario.movimientos.size(),
                    solitario.intentos);
            System.out.println();

            System.out.println("Tablero solucion:");
            System.out.println(solitario.toString());

            System.out.print("Movimientos: ");
            for (String movimiento : solitario.movimientos) {
                System.out.print(movimiento);
                System.out.print(" ");
            }
            System.out.println(".");
        } else {
            System.out.println("Solucion NO Encontrada!");
        }

    }

    /**
     * The movimientos.
     */
    public enum Movimiento {
        ARRIBA,
        DERECHA,
        ABAJO,
        IZQUIERDA
    }

}
