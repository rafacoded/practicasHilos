package com.hilos.practica1.ej3;

public class ContadorConcurrente {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, introduce al menos un fichero como argumento.");
            return;
        }

        long t_comienzo = System.currentTimeMillis();

        Thread[] hilos = new Thread[args.length];
        for (int i = 0; i < args.length; i++) {
            hilos[i] = new Thread(new ContadorHilo(args[i]));
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long t_fin = System.currentTimeMillis();
        long tiempototal = t_fin - t_comienzo;
        System.out.println("\nEjecución concurrente completada en " + tiempototal + " ms");
    }
}