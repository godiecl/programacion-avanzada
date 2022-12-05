/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.backtracking;

import java.util.concurrent.TimeUnit;

/**
 * The Cuadrado Magico.
 *
 * @author Programacion Avanzada.
 */
public final class CuadradoMagico {

    /**
     * The Main.
     */
    public static void main(String[] args) {

        // lado del matriz
        int n = 3;

        // matriz de los valores
        int[][] matriz = new int[n][n];

        System.out.println("Buscando solucion...");

        // impresion del matriz
        imprimirMatriz(matriz);

        long startTime = System.nanoTime();

        // si es posible encontrar solucion a partir de la posicion (0,0)
        if (resolverCuadradoMagico(0, 0, matriz)) {
            imprimirMatriz(matriz);
        } else {
            System.out.println("No existe solucion :(");
        }
        System.out.printf("Time: %d ms.", (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime)));
    }

    /**
     * Metodo recursivo para resolver el problema del cuadrado magico.
     *
     * @param fila    actual donde se esta trabajando.
     * @param columna actual donde se esta trabajando.
     * @param matriz  magico.
     * @return true si fue posible resolver el cuadrado magico, false en caso contrario.
     */
    private static boolean resolverCuadradoMagico(final int fila, final int columna, final int[][] matriz) {

        // posicion (fila, columna) donde probar el siguiente numero
        int filaActual = fila;
        int columnaActual = columna;

        // si me sali del matriz por la derecha, me muevo a la siguiente fila
        if (columnaActual == matriz.length) {
            filaActual++;
            columnaActual = 0;

            // llegue al final: verificar solucion
            if (filaActual == matriz.length) {
                return isSolucion(matriz);
            }
        }

        // ciclo para probar todos los numeros
        for (int valor = 1; valor <= matriz.length * matriz.length; valor++) {

            // imprimir en cada caso (debug)
            // imprimirMatriz(matriz);

            // si es aceptable el trio (valor, fila, columna) ..
            if (isAceptable(valor, filaActual, columnaActual, matriz)) {

                // .. lo asigno.
                matriz[filaActual][columnaActual] = valor;

                // si al colocar ese valor no hay solucion
                if (!resolverCuadradoMagico(filaActual, columnaActual + 1, matriz)) {
                    matriz[filaActual][columnaActual] = 0;
                } else {
                    return true;
                }
            }
        }
        // no habia solucion por aca
        return false;
    }

    /**
     * Metodo que verifica si la posicion (valor, fila, columna) es aceptable.
     *
     * @param valor    del numero a probar.
     * @param fila     a probar.
     * @param columna  a probar.
     * @param cuadrado matriz de datos
     * @return true si es posible agregarlo.
     */
    private static boolean isAceptable(int valor, int fila, int columna, int[][] cuadrado) {
        // me sali por fila
        if (fila < 0 || fila >= cuadrado.length) {
            return false;
        }
        // me sali por columna
        if (columna < 0 || columna >= cuadrado.length) {
            return false;
        }
        // ya esta ocupado
        if (cuadrado[fila][columna] != 0) {
            return false;
        }
        // el valor ya se encuentra en la matriz
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                if (cuadrado[i][j] == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verifica si la matriz tiene solucion.
     *
     * @param matriz a verificar.
     * @return true si es un cuadrado magico.
     */
    private static boolean isSolucion(int[][] matriz) {

        // suma: (n^3 + n)/2
        int suma = (matriz.length * matriz.length * matriz.length + matriz.length) / 2;

        // suma de las diagonales
        int sumaDiagonalPrincipal = 0;
        int sumaDiagonalSecundaria = 0;

        // ciclo para la revision de la matriz
        for (int i = 0; i < matriz.length; i++) {

            // sumadores de las filas y columnas
            int sumaFila = 0;
            int sumaColumna = 0;

            // suma de cada fila y cada columna
            for (int j = 0; j < matriz.length; j++) {
                sumaFila += matriz[i][j];
                sumaColumna += matriz[j][i];
            }
            // si alguna fila o columna no tiene la suma correcta
            if (sumaFila != suma || sumaColumna != suma) {
                return false;
            }

            // suma de las diagonales
            sumaDiagonalPrincipal += matriz[i][i];
            sumaDiagonalSecundaria += matriz[matriz.length - i - 1][i];
        }

        // si alguna diagonal no tiene la suma correcta
        return sumaDiagonalPrincipal == suma && sumaDiagonalSecundaria == suma;
    }

    /**
     * Imprime el matriz magico.
     *
     * @param matriz a imprimir.
     */
    private static void imprimirMatriz(int[][] matriz) {

        for (int f = 0; f < matriz.length; f++) {
            System.out.print("[ ");
            for (int c = 0; c < matriz[f].length; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

}
