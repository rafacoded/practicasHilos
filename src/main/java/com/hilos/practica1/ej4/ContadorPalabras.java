package com.hilos.practica1.ej4;

import java.io.*;
import java.util.StringTokenizer;

class ContadorPalabras implements Runnable {
    private String nombreFichero;

    public ContadorPalabras(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea);
                contador += st.countTokens();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + nombreFichero);
            return;
        }

        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;

        System.out.println("Fichero: " + nombreFichero +
                " → " + contador + " palabras (" + tiempo + " ms)");
    }
}
