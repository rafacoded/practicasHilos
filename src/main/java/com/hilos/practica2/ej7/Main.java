package com.hilos.practica2.ej7;

public class Main {

    static void main(String[] args) {

        Cuenta cuenta = new Cuenta(1000, 2000);

        Persona p1 = new Persona("Alice", cuenta);
        Persona p2 = new Persona("Bob", cuenta);
        Persona p3 = new Persona("Charlie", cuenta);

        p1.start();
        p2.start();
        p3.start();
    }
}

