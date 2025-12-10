package com.hilos.practica1.ej3;
import java.io.*;

class ContadorHilo implements Runnable {
    private String nombreFichero;

    public ContadorHilo(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    @Override
    public void run() {
        try {
            long inicio = System.currentTimeMillis();

            FileReader fr = new FileReader(nombreFichero);
            int contador = 0;
            while (fr.read() != -1) {
                contador++;
            }
            fr.close();

            long fin = System.currentTimeMillis();
            System.out.println("Fichero: " + nombreFichero + " -> " + contador +
                    " caracteres. (Tardó " + (fin - inicio) + " ms)");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + nombreFichero);
        }
    }
}


