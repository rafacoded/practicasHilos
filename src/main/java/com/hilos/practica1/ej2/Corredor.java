package com.hilos.practica1.ej2;

public class Corredor implements Runnable {
    private String mensaje;

    public Corredor(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        try {
            Thread.sleep(id * 100); // tiempo proporcional al ID
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hola mundo " + mensaje + " desde el hilo " + id);
    }



}
