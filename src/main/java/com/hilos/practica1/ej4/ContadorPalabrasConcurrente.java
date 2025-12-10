package com.hilos.practica1.ej4;

public class ContadorPalabrasConcurrente {
    static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, introduce al menos un fichero como argumento.");
            System.out.println("Ejemplo: java ContadorPalabrasConcurrente archivo1.txt archivo2.txt archivo3.txt");
            return;
        }

        long tInicio = System.currentTimeMillis();

        Thread[] hilos = new Thread[args.length];
        for (int i = 0; i < args.length; i++) {
            hilos[i] = new Thread(new ContadorPalabras(args[i]));
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long tFin = System.currentTimeMillis();
        long tiempoTotal = tFin - tInicio;

        System.out.println("\nProceso completo en " + tiempoTotal + " milisegundos.");
    }
}