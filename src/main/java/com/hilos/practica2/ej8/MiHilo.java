package com.hilos.practica2.ej8;

public class MiHilo extends Thread {

    private boolean corriendo = true;
    private boolean pausado = false;

    private int contador = 0;
    private long milisSleep;

    private Runnable onStateChange;

    public MiHilo(String nombre, long milisSleep, Runnable onStateChange) {
        super(nombre);
        this.milisSleep = milisSleep;
        this.onStateChange = onStateChange;
    }

    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        try {
            while (corriendo) {

                synchronized (this) {
                    while (pausado) {
                        onStateChange.run();
                        wait();
                    }
                }

                onStateChange.run();

                contador++;
                System.out.println(getName() + " | contador: " + contador);

                Thread.sleep(milisSleep);
            }
        }
        catch (InterruptedException e) { }
    }

    public synchronized void pausar() {
        pausado = true;
    }

    public synchronized void reanudar() {
        pausado = false;
        notifyAll();
    }

    public void detener() {
        corriendo = false;
        interrupt();
    }

    public boolean estaPausado() {
        return pausado;
    }
}

