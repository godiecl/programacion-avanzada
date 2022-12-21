/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.catedra.examen;

import cl.ucn.disc.pa.catedra.examen.services.Concordancia;
import cl.ucn.disc.pa.catedra.examen.services.ConcordanciaImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.List;

/**
 * The Class.
 *
 * @author Programacion Avanzada.
 */
public final class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws IOException {

        // the Concordancia
        Concordancia concordancia = new ConcordanciaImpl();

        // the list of lines
        // lectura del archivo
        List<String> lines = Files.readAllLines(Path.of("catedra\\el_principito.txt"));

        // iterate over the list of lines
        int nLine = 0;
        int nWords = 0;
        for (String line : lines) {

            // number of line
            nLine++;

            // remove the punctuation
            line = line.replaceAll("[.,]", "");
            line = Normalizer.normalize(line, Normalizer.Form.NFD);
            line = line.replaceAll("[^\\p{ASCII}]", "");

            // separate the words
            String[] words = line.split("\\s+");

            // iterate over the words
            for (String word : words) {
                nWords++;
                // add the word
                concordancia.addPalabra(word.toLowerCase(), nLine);
            }
        }

        System.out.println("* Lineas:" + nLine + ", Palabras: " + nWords);
        System.out.println("* Concordancia:\n" + concordancia.toString());
        System.out.println("* Numero de palabras unicas: " + concordancia.getNumeroPalabras());

        System.out.println("* Palabras: ");
        for (String palabra : concordancia.getPalabrasAlfabetico()) {
            System.out.println(palabra);
        }

        int repeticiones = 2;
        System.out.println("* Eliminadas " + concordancia.removePalabras(repeticiones) + " palabras con menos de " + repeticiones + " repeticiones.");
        System.out.println("* Concordancia:\n" + concordancia.toString());

    }

}
