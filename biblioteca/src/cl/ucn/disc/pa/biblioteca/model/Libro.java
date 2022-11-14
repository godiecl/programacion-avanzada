/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.biblioteca.model;

/**
 * The Class.
 *
 * @author Programacion Avanzada.
 */
public final class Libro {

    /**
     * Identificador del Libro.
     */
    private final String isbn;

    /**
     * Titulo del Libro.
     */
    private final String titulo;

    /**
     * Si el Libro se encuentra en prestado.
     */
    private boolean prestado;

    /**
     * The Constructor.
     *
     * @param isbn   del libro.
     * @param titulo del libro.
     */
    public Libro(String isbn, String titulo, boolean prestado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.prestado = false;
    }

    /**
     * el codigo del Libro.
     *
     * @return the Isbn.
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * El nombre del Libro.
     *
     * @return the Titulo.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Si el libro se encuentra en prestado.
     *
     * @return the Prestado.
     */
    public boolean isPrestado() {
        return this.prestado;
    }

    /**
     * Set si el libro esta prestado o no.
     *
     * @param prestado true si esta prestado, false si no.
     */
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    /**
     * Si un objeto el igual a este libro.
     *
     * @param o a comparar.
     * @return true si los isbn son iguales.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Libro libro = (Libro) o;
        return isbn.equals(libro.isbn);
    }

}
