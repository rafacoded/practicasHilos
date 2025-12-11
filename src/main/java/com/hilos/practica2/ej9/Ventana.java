package com.hilos.practica2.ej9;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private JButton btnStart, btnStop;
    private JButton btnInterrupt1, btnInterrupt2;
    private JLabel lblEstado1, lblEstado2;

    private MiHilo hilo1, hilo2;

    public Ventana() {
        super("Actividad 9 - Interrupciones");

        setLayout(new GridLayout(4, 2, 10, 10));

        btnStart = new JButton("Comenzar proceso");
        btnStop = new JButton("Finalizar proceso");

        btnInterrupt1 = new JButton("Interrumpir Hilo 1");
        btnInterrupt2 = new JButton("Interrumpir Hilo 2");

        lblEstado1 = new JLabel("Hilo 1: No iniciado");
        lblEstado2 = new JLabel("Hilo 2: No iniciado");

        add(btnStart);
        add(btnStop);
        add(btnInterrupt1);
        add(btnInterrupt2);
        add(lblEstado1);
        add(lblEstado2);

        btnStop.setEnabled(false);
        btnInterrupt1.setEnabled(false);
        btnInterrupt2.setEnabled(false);

        // -------- EVENTOS --------

        btnStart.addActionListener(e -> iniciarHilos());
        btnStop.addActionListener(e -> finalizarHilos());
        btnInterrupt1.addActionListener(e -> interrumpirHilo(hilo1, lblEstado1));
        btnInterrupt2.addActionListener(e -> interrumpirHilo(hilo2, lblEstado2));

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                finalizarHilos();
            }
        });

        setSize(420, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarHilos() {
        btnStart.setEnabled(false);

        hilo1 = new MiHilo("Hilo-1", 500);
        hilo2 = new MiHilo("Hilo-2", 1000);

        hilo1.start();
        hilo2.start();

        lblEstado1.setText("Hilo 1: Corriendo");
        lblEstado2.setText("Hilo 2: Corriendo");

        btnStop.setEnabled(true);
        btnInterrupt1.setEnabled(true);
        btnInterrupt2.setEnabled(true);
    }

    private void interrumpirHilo(MiHilo hilo, JLabel label) {
        if (hilo != null && hilo.isAlive()) {
            hilo.interrupt();
            label.setText("Interrumpido. Contador final: " + hilo.getContador());
        }
    }

    private void finalizarHilos() {
        if (hilo1 != null) {
            hilo1.interrupt();
            System.out.println("FINAL Hilo1 = " + hilo1.getContador());
        }

        if (hilo2 != null) {
            hilo2.interrupt();
            System.out.println("FINAL Hilo2 = " + hilo2.getContador());
        }

        lblEstado1.setText("Hilo 1 finalizado");
        lblEstado2.setText("Hilo 2 finalizado");

        btnInterrupt1.setEnabled(false);
        btnInterrupt2.setEnabled(false);
        btnStop.setEnabled(false);
    }
}
