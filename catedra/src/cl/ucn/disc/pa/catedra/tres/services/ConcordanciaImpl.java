/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.catedra.tres.services;

import cl.ucn.disc.pa.catedra.tres.model.Palabra;

/**
 * The implementation of Concordancia.
 *
 * @author Programacion Avanzada.
 */
public final class ConcordanciaImpl implements Concordancia {

    /**
     * The Cabeza.
     */
    private Nodo head;

    /**
     * The constructor.
     */
    public ConcordanciaImpl() {
        this.head = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addPalabra(String palabra, int linea) {

        // verificacion de validez de los parametros
        if (palabra == null || palabra.isEmpty()) {
            throw new IllegalArgumentException("No se permite palabra nula o vacia");
        }

        // busqueda de la palabra por si existe previamente
        Nodo nodo = this.buscarPalabra(palabra);
        if (nodo != null) {
            // la palabra ya existe
            nodo.palabra.addLinea(linea);
            return false;
        }

        // nuevo nodo a insertar
        Nodo nuevoNodo = new Nodo(new Palabra(palabra));
        nuevoNodo.palabra.addLinea(linea);

        // la palabra no existe: insertar ordenado
        // caso 1: lista vacia o la palabra es la nueva cabeza
        if (this.head == null || this.head.palabra.getPalabra().compareTo(palabra) > 0) {
            // insertar al inicio
            nuevoNodo.siguiente = this.head;
            this.head = nuevoNodo;
            return true;
        }

        // caso 2: localizo el lugar donde insertar
        Nodo actual = this.head;
        while (actual.siguiente != null && actual.siguiente.palabra.getPalabra().compareTo(palabra) < 0) {
            actual = actual.siguiente;
        }

        // insertar en el lugar encontrado
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;

        return true;
    }

    /**
     * Busca la palabra en la lista.
     *
     * @param palabra a buscar.
     * @return el nodo donde se encuentra la palabra.
     */
    private Nodo buscarPalabra(String palabra) {
        // itero sobre la lista buscando el nodo que tiene la palabra.
        for (Nodo nodo = this.head; nodo != null; nodo = nodo.siguiente) {
            if (nodo.palabra.getPalabra().equals(palabra)) {
                return nodo;
            }
        }
        // no encontre la palabra.
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addSignificado(String palabra, String significado) {
        //  validacion
        if (palabra == null || palabra.isEmpty()) {
            throw new IllegalArgumentException("No se permite palabra nula o vacia");
        }
        if (significado == null || significado.isEmpty()) {
            throw new IllegalArgumentException("No se permite significado nulo o vacia");
        }

        // buscar la palabra a la cual se debe agregar el significado
        Nodo nodo = this.buscarPalabra(palabra);
        if (nodo != null) {
            nodo.palabra.addSignificado(significado);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRepeticiones(String palabra) {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] getLineasPalabra(String palabra) {
        return new int[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumeroPalabras() {
        int palabras = 0;
        for (Nodo nodo = this.head; nodo != null; nodo = nodo.siguiente) {
            palabras++;
        }
        return palabras;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int removePalabras(int repeticiones) {
        int contadorEliminadas = 0;
        while (this.eliminar(repeticiones)) {
            contadorEliminadas++;
        }

        return contadorEliminadas;
    }


    /**
     * Elimina la palabra de la lista que tengan menos de repeticiones.
     *
     * @param repeticiones numero de repeticiones minimo a eliminar.
     * @return true si se elimino una palabra, false en caso contrario.
     */
    private boolean eliminar(int repeticiones) {
        for (Nodo nodo = this.head; nodo != null; nodo = nodo.siguiente) {
            if (nodo.palabra.getLineas() <= repeticiones) {
                // eliminar el nodo
                this.eliminar(nodo.palabra.getPalabra());
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina una palabra de la lista.
     *
     * @param palabra a eliminar.
     */
    private void eliminar(String palabra) {
        if (this.head.palabra.getPalabra().equals(palabra)) {
            this.head = this.head.siguiente;
            return;
        }

        for (Nodo aux = this.head; aux.siguiente != null; aux = aux.siguiente) {
            if (aux.siguiente.palabra.getPalabra().equals(palabra)) {
                aux.siguiente = aux.siguiente.siguiente;
                return;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getPalabrasAlfabetico() {
        String[] palabras = new String[this.getNumeroPalabras()];
        int i = 0;
        for (Nodo nodo = this.head; nodo != null; nodo = nodo.siguiente) {
            palabras[i++] = nodo.palabra.getPalabra();
        }
        return palabras;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getPabrasFrecuencias() {
        return new String[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Nodo nodo = this.head; nodo != null; nodo = nodo.siguiente) {
            sb.append(nodo.palabra.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * The Nodo.
     */
    private static final class Nodo {

        /**
         * The palabra.
         */
        Palabra palabra;

        /**
         * The siguiente.
         */
        Nodo siguiente;

        /**
         * The constructor.
         *
         * @param palabra to build.
         */
        public Nodo(Palabra palabra) {
            this.palabra = palabra;
        }

    }
}
