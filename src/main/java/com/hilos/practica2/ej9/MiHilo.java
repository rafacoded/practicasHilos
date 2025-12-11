package com.hilos.practica2.ej9;

public class MiHilo extends Thread {

    private int contador = 0;
    private long milisSleep;

    public MiHilo(String nombre, long milisSleep) {
        super(nombre);
        this.milisSleep = milisSleep;
    }

    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        try {
            while (true) {
                contador++;
                System.out.println(getName() + " contador: " + contador);
                Thread.sleep(milisSleep);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " ha sido interrumpido.");
        }
    }
}

