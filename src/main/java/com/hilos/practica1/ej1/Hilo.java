package com.hilos.practica1.ej1;

public class Hilo extends Thread {

    public Hilo(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        System.out.println("Hola mundo desde el hilo " + this.getName());
    }
}
