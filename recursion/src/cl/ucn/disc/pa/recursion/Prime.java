/*
 * Copyright (c) 2022 Programacion Avanzada,
 * Departamento de Ingenieria de Sistemas y Computacion,
 * Universidad Catolica del Norte,
 * Antofagasta, Chile.
 */

package cl.ucn.disc.pa.recursion;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * The Prime Example.
 *
 * @author Programacion Avanzada.
 */
public final class Prime {

    /**
     * The Main.
     */
    public static void main(String[] args) {

        // The number of primes to find
        long end = 50 * 1000 * 1000;
        System.out.println("Finding Primes from 0 to " + end + " ...");

        // The start time
        long start = System.nanoTime();

        // Counter
        AtomicInteger counter = new AtomicInteger(0);

        // The stream in parallel
        IntStream.rangeClosed(0, 50 * 1000 * 1000).parallel().forEach(n -> {
            if (isPrime(n)) {
                // System.out.println(n + " is prime.");
                counter.incrementAndGet();
            }
        });
        System.out.println("Founded " + counter.get() + " primes in " + TimeUnit.MILLISECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS) + "ms");

    }

    /**
     * Check if a number is prime.
     *
     * @param n the number to check.
     * @return true if n is prime.
     */
    private static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        // call the isPrime
        return isPrime(n, 2);
    }

    /**
     * Return true if n is prime.
     *
     * @param n   the number to check.
     * @param div the divisor.
     * @return true is the n is prime.
     */
    private static boolean isPrime(long n, long div) {
        // the base case
        if (n <= 2) {
            return n == 2;
        }
        // the n is divisible by div
        if (n % div == 0) {
            return false;
        }
        // if the div is greater than the square root of n
        if (div * div > n) {
            return true;
        }
        // recursive call
        return isPrime(n, div + 1);
    }
}
