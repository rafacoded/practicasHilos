package com.hilos.practica2.ej11;

public class Main {
    static void main(String[] args) {

        int jugadores = 3;

        Arbitro arbitro = new Arbitro(jugadores);

        for (int i = 1; i <= jugadores; i++) {
            new Jugador(i, arbitro).start();
        }
    }
}
