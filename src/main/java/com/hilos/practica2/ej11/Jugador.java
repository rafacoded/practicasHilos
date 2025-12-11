package com.hilos.practica2.ej11;

public class Jugador extends Thread {

    private int id;
    private Arbitro arbitro;

    public Jugador(int id, Arbitro arbitro) {
        this.id = id;
        this.arbitro = arbitro;
    }

    @Override
    public void run() {
        while (!arbitro.acabado()) {

            synchronized (arbitro) {
                while (arbitro.getTurno() != id && !arbitro.acabado()) {
                    try {
                        arbitro.wait();
                    } catch (InterruptedException e) {}
                }

                if (arbitro.acabado()) break;

                int numero = 1 + (int)(10 * Math.random());

                arbitro.jugar(id, numero);
            }

            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
    }
}
