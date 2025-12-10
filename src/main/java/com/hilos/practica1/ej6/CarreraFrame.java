package com.hilos.practica1.ej6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarreraFrame extends JFrame {

    private JProgressBar[] barras = new JProgressBar[3];
    private JSlider[] sliders = new JSlider[3];
    private JTextField[] campos = new JTextField[3];
    private Corredor[] corredores = new Corredor[3];
    private JButton iniciar;

    private boolean carreraEnCurso = false;

    public CarreraFrame() {
        setTitle("Carrera de Hilos");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        for (int i = 0; i < 3; i++) {
            JPanel panel = new JPanel(new GridLayout(1, 3));

            barras[i] = new JProgressBar(0, 100);
            barras[i].setValue(0);

            sliders[i] = new JSlider(1, 10, 5);
            sliders[i].setMajorTickSpacing(1);
            sliders[i].setPaintTicks(true);
            sliders[i].setPaintLabels(true);

            campos[i] = new JTextField("0");
            campos[i].setEditable(false);

            panel.add(barras[i]);
            panel.add(sliders[i]);
            panel.add(campos[i]);

            add(panel);
        }

        iniciar = new JButton("Iniciar carrera");
        add(iniciar);

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!carreraEnCurso) {
                    iniciarCarrera();
                }
            }
        });

        setVisible(true);
    }

    private void iniciarCarrera() {
        carreraEnCurso = true;
        iniciar.setEnabled(false);

        corredores = new Corredor[3];

        for (int i = 0; i < 3; i++) {
            long tiempo = (long) (Math.random() * 1000 + 1); // prueba con tiempo aleatorio

            corredores[i] = new Corredor(i, tiempo, barras[i], campos[i], sliders[i], this);
            corredores[i].setPriority(sliders[i].getValue());
            corredores[i].start();
        }
    }

    public void carreraFinalizada(int ganador) {
        JOptionPane.showMessageDialog(this,
                "🏁 El ganador es el hilo " + (ganador + 1));

        iniciar.setEnabled(true);
        carreraEnCurso = false;
    }

    public static void main(String[] args) {
        new CarreraFrame();
    }
}
