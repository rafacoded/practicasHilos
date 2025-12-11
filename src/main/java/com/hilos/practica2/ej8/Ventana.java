package com.hilos.practica2.ej8;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private JButton btnStart, btnStop, btnPause1, btnPause2;
    private JLabel lblEstado1, lblEstado2;

    private MiHilo hilo1, hilo2;

    public Ventana() {
        super("Control de Hilos");

        setLayout(new GridLayout(4, 2, 10, 10));

        btnStart = new JButton("Comenzar proceso");
        btnStop = new JButton("Finalizar proceso");

        btnPause1 = new JButton("Suspender/Reanudar Hilo 1");
        btnPause2 = new JButton("Suspender/Reanudar Hilo 2");

        lblEstado1 = new JLabel("Hilo 1: No iniciado");
        lblEstado2 = new JLabel("Hilo 2: No iniciado");

        add(btnStart);
        add(btnStop);
        add(btnPause1);
        add(btnPause2);
        add(lblEstado1);
        add(lblEstado2);

        btnStop.setEnabled(false);
        btnPause1.setEnabled(false);
        btnPause2.setEnabled(false);

        // ACTION LISTENERS
        btnStart.addActionListener(e -> iniciarHilos());
        btnStop.addActionListener(e -> detenerHilos());

        btnPause1.addActionListener(e -> alternarPausa(hilo1));
        btnPause2.addActionListener(e -> alternarPausa(hilo2));

        setSize(380, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                detenerHilos();
            }
        });
    }

    private void iniciarHilos() {
        btnStart.setEnabled(false);

        hilo1 = new MiHilo("Hilo-1", 500, () ->
                actualizarEstados());
        hilo2 = new MiHilo("Hilo-2", 1000, () ->
                actualizarEstados());

        hilo1.start();
        hilo2.start();

        btnStop.setEnabled(true);
        btnPause1.setEnabled(true);
        btnPause2.setEnabled(true);
    }

    private void detenerHilos() {
        if (hilo1 != null) hilo1.detener();
        if (hilo2 != null) hilo2.detener();

        System.out.println("Final contador Hilo1 = " + (hilo1 != null ? hilo1.getContador() : 0));
        System.out.println("Final contador Hilo2 = " + (hilo2 != null ? hilo2.getContador() : 0));

        lblEstado1.setText("Hilo 1 detenido");
        lblEstado2.setText("Hilo 2 detenido");

        btnPause1.setEnabled(false);
        btnPause2.setEnabled(false);
        btnStop.setEnabled(false);
    }

    private void alternarPausa(MiHilo hilo) {
        if (hilo == null) return;

        if (hilo.estaPausado()) {
            hilo.reanudar();
        } else {
            hilo.pausar();
        }
        actualizarEstados();
    }

    private void actualizarEstados() {
        SwingUtilities.invokeLater(() -> {
            lblEstado1.setText("Hilo 1: " +
                    (hilo1 != null && hilo1.estaPausado() ? "Suspendido" : "Corriendo"));

            lblEstado2.setText("Hilo 2: " +
                    (hilo2 != null && hilo2.estaPausado() ? "Suspendido" : "Corriendo"));
        });
    }
}
