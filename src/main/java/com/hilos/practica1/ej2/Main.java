package com.hilos.practica1.ej2;

public class Main {
    static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Thread hilo = new Thread(new Corredor("mensaje " + i));
            hilo.start();
        }
    }
}
