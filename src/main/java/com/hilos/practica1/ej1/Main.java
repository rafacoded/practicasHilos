package com.hilos.practica1.ej1;

public class Main {
    static void main() {
        for (int i = 0; i < 5; i++) {
            Hilo hilo = new Hilo("Hilo " + i);
            hilo.start();
        }
    }
}
