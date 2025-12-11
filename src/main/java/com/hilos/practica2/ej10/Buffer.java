package com.hilos.practica2.ej10;

import java.util.LinkedList;

public class Buffer {

    private LinkedList<Character> buffer = new LinkedList<>();
    private boolean productorFinalizado = false;

    public synchronized void put(char c) {
        buffer.add(c);
        notifyAll();
    }

    public synchronized Character get() throws InterruptedException {
        while (buffer.isEmpty()) {

            if (productorFinalizado) {
                return null; // señal de terminación
            }
            wait();
        }

        return buffer.removeFirst();
    }

    public synchronized void setProductorFinalizado() {
        productorFinalizado = true;
        notifyAll(); // para despertar consumidores bloqueados
    }
}
