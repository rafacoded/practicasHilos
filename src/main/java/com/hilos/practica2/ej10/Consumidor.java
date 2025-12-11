package com.hilos.practica2.ej10;

public class Consumidor extends Thread {

    private Buffer buffer;

    public Consumidor(Buffer buffer, String nombre) {
        super(nombre);
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Character c = buffer.get();

                if (c == null) {
                    break; // fin real del consumo
                }

                System.out.println(getName() + " consumió: " + c);
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrumpido.");
        }

        System.out.println(getName() + ": finalizando.");
    }
}

