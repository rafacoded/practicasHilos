package com.hilos.practica2.ej7;

public class Persona extends Thread {

    private Cuenta cuenta;

    public Persona(String nombre, Cuenta cuenta) {
        super(nombre);
        this.cuenta = cuenta;
    }

    private int cantidadAleatoria() {
        return (int) (Math.random() * 500 + 1);
    }

    @Override
    public void run() {
        try {
            cuenta.ingresar(cantidadAleatoria(), getName());
            Thread.sleep(300);

            cuenta.reintegrar(cantidadAleatoria(), getName());
            Thread.sleep(300);

            cuenta.ingresar(cantidadAleatoria(), getName());
            Thread.sleep(300);

            cuenta.reintegrar(cantidadAleatoria(), getName());

        } catch (InterruptedException e) {
            System.out.println(getName() + " ha sido interrumpido.");
        }
    }
}
