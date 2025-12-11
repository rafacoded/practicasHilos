package com.hilos.practica2.ej10;

import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {

    private Buffer buffer;
    private String fichero;

    public Productor(Buffer buffer, String fichero) {
        this.buffer = buffer;
        this.fichero = fichero;
    }

    @Override
    public void run() {
        try (FileReader fr = new FileReader(fichero)) {

            int c;
            while ((c = fr.read()) != -1) {
                buffer.put((char) c);
            }

            System.out.println("Productor: fin de archivo alcanzado.");

        } catch (IOException e) {
            System.out.println("Error en productor: " + e.getMessage());
        }

        buffer.setProductorFinalizado();
        System.out.println("Productor: he terminado.");
    }
}
