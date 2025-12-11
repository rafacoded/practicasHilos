package com.hilos.practica2.ej10;

import java.io.File;

public class Main {

    static void main(String[] args) throws InterruptedException {

        Buffer buffer = new Buffer();

        Productor productor = new Productor(buffer, "texto.txt");

        Consumidor c1 = new Consumidor(buffer, "Consumidor-1");
        Consumidor c2 = new Consumidor(buffer, "Consumidor-2");
        Consumidor c3 = new Consumidor(buffer, "Consumidor-3");

        productor.start();
        c1.start();
        c2.start();
        c3.start();

        productor.join();
        c1.join();
        c2.join();
        c3.join();

        System.out.println("\n--- ESTADOS FINALES ---");
        System.out.println("C1: " + c1.getState());
        System.out.println("C2: " + c2.getState());
        System.out.println("C3: " + c3.getState());
        System.out.println("------------------------");
    }
}
