package com.hilos.practica2.ej11;

public class Arbitro {

    private int numJugadores;
    private int turno;
    private int numeroAdivinar;
    private boolean gameOver = false;

    public Arbitro(int numJugadores) {
        this.numJugadores = numJugadores;
        this.turno = 1;
        this.numeroAdivinar = 1 + (int)(10 * Math.random());

        System.out.println("El número que tienes que sacar es " + numeroAdivinar);
    }

    public synchronized int getTurno() {
        return turno;
    }

    public synchronized boolean acabado() {
        return gameOver;
    }

    public synchronized void jugar(int jugador, int numero) {
        if (gameOver) return;

        System.out.println("\tTurno del jugador " + jugador);
        System.out.println("El jugador " + jugador + " saca " + numero);

        if (numero == numeroAdivinar) {
            System.out.println("🎉 El jugador " + jugador + " ha acertado. ¡Fin del juego!");
            gameOver = true;
            notifyAll();
            return;
        }

        turno = (jugador % numJugadores) + 1;

        notifyAll();
    }
}

