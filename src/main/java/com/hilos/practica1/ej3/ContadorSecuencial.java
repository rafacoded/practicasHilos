package com.hilos.practica1.ej3;
import java.io.*;

public class ContadorSecuencial {
    static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, introduce al menos un fichero como argumento.");
            return;
        }

        long t_comienzo = System.currentTimeMillis();

        for (String nombreFichero : args) {
            try {
                FileReader fr = new FileReader(nombreFichero);
                int contador = 0;
                while (fr.read() != -1) {
                    contador++;
                }
                fr.close();
                System.out.println("Fichero: " + nombreFichero + " -> " + contador + " caracteres.");
            } catch (IOException e) {
                System.out.println("Error al leer el fichero: " + nombreFichero);
            }
        }

        long t_fin = System.currentTimeMillis();
        long tiempototal = t_fin - t_comienzo;
        System.out.println("\nEjecución secuencial completada en " + tiempototal + " ms");
    }
}
