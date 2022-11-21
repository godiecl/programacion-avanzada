/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.diccionario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The Main of Diccionario.
 *
 * @author Programacion Avanzada.
 */
public final class TheMain {

    /**
     * The Main.
     */
    public static void main(String[] args) {

        // instanciacion del diccionario
        IDiccionario diccionario = new DiccionarioImpl();

        // cargar el diccionario desde un archivo
        cargarArchivo(diccionario, "diccionario\\diccionario.txt");

        System.out.println("Tamanio del Diccionario : " + diccionario.cantidadDePalabras());
        System.out.println("Palabras existentes     : " + Arrays.toString(diccionario.listadoPalabras()));
        System.out.println("Palabras con P          : " + Arrays.toString(diccionario.listadoPalabras("P")));

    }

    /**
     * Metodo que lee un archivo y carga las palabras en el.
     *
     * @param diccionario a cargar.
     * @param filename    nombre del archivo
     */
    private static void cargarArchivo(IDiccionario diccionario, String filename) {

        // try-with-resources: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try (Scanner in = new Scanner(new File(filename))) {

            // mientras existan lineas en el archivo
            while (in.hasNextLine()) {

                // leo la palabra y su significado
                String palabra = in.next();
                String significado = in.nextLine();

                // si la insercion no fue exitosa, lo indico
                if (!diccionario.insertarPalabra(palabra, significado)) {
                    System.err.println("No se logro insertar la palabra: " + palabra);
                } else {
                    System.out.println("Palabra <" + palabra + "> insertada correctamente.");
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("No se logro leer el archivo: " + filename, e);
        }

    }

}
