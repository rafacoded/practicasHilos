package com.hilos.practica1.ej6;

import javax.swing.*;

class Corredor extends Thread {

    private int id;
    private long tiempoDormir;
    private JProgressBar barra;
    private JTextField campo;
    private JSlider slider;
    private CarreraFrame padre;

    private boolean terminado = false;
    private static boolean ganadorDeclarado = false;

    public Corredor(int id, long tiempoDormir, JProgressBar barra,
                    JTextField campo, JSlider slider, CarreraFrame padre) {

        this.id = id;
        this.tiempoDormir = tiempoDormir;
        this.barra = barra;
        this.campo = campo;
        this.slider = slider;
        this.padre = padre;
    }

    @Override
    public void run() {

        int progreso = 0;
        while (progreso < 100 && !terminado) {

            this.setPriority(slider.getValue());

            progreso++;
            barra.setValue(progreso);
            campo.setText(String.valueOf(progreso));

            try {
                Thread.sleep(tiempoDormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!ganadorDeclarado) {
            ganadorDeclarado = true;
            padre.carreraFinalizada(id);
            resetGanador();
        }
    }

    private synchronized static void resetGanador() {
        ganadorDeclarado = false;
    }
}
