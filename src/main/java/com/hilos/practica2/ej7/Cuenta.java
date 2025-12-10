package com.hilos.practica2.ej7;

public class Cuenta {

    private int saldo;
    private int saldoMaximo;

    public Cuenta(int saldoInicial, int saldoMaximo) {
        this.saldo = saldoInicial;
        this.saldoMaximo = saldoMaximo;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void ingresar(int cantidad, String nombrePersona) {
        System.out.println(nombrePersona + " intenta ingresar " + cantidad + "€");

        if (saldo + cantidad > saldoMaximo) {
            System.out.println("❌ ERROR: Ingreso rechazado. Se superaría el saldo máximo (" +
                    saldoMaximo + "€). Saldo actual: " + saldo + "€");
            return;
        }

        saldo += cantidad;

        System.out.println("✔ " + nombrePersona + " ingresó " + cantidad +
                "€. Saldo actual: " + saldo + "€");
    }

    public synchronized void reintegrar(int cantidad, String nombrePersona) {
        System.out.println(nombrePersona + " intenta retirar " + cantidad + "€");

        if (saldo - cantidad < 0) {
            System.out.println("❌ ERROR: Reintegro rechazado. No hay saldo suficiente. Saldo actual: " + saldo + "€");
            return;
        }

        saldo -= cantidad;

        System.out.println("✔ " + nombrePersona + " retiró " + cantidad +
                "€. Saldo actual: " + saldo + "€");
    }
}
