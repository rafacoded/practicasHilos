package com.hilos.practica1.ej5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReboteFrame extends JFrame implements Runnable {

    private int x = 1;
    private int y = 100;
    private int velocidad = 3;
    private boolean enMarcha = true;

    private JButton boton;
    private JPanel panel;
    private Thread hilo;

    public ReboteFrame() {

        setTitle("Rebote de Letra con Hilo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boton = new JButton("Finalizar Hilo");
        add(boton, BorderLayout.SOUTH);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setFont(new Font("Arial", Font.BOLD, 32));
                g.setColor(Color.BLUE);
                g.drawString("A", x, y);
            }
        };

        panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);

        // Acción del botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enMarcha = !enMarcha;

                if (enMarcha) {
                    boton.setText("Finalizar Hilo");
                } else {
                    boton.setText("Reanudar Hilo");
                }
            }
        });

        // Crear y arrancar el hilo
        hilo = new Thread(this);
        hilo.start();

        setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            if (enMarcha) {
                x += velocidad;

                // Rebote derecha
                if (x > panel.getWidth() - 20) {
                    velocidad = -velocidad;
                }

                // Rebote izquierda
                if (x < 1) {
                    velocidad = -velocidad;
                }

                panel.repaint();
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método main para arrancar
    public static void main(String[] args) {
        new ReboteFrame();
    }
}
