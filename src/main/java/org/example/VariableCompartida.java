package org.example;

public class VariableCompartida {
    private int valor;

    public void set(int valor) {
        this.valor = valor;
    }

    public int get() {
        return valor;
    }

    public void inc() {
        valor++;
    }
}

//public class VariableCompartida {
//    private int valor;
//
//    public synchronized void set(int valor) {
//        this.valor = valor;
//    }
//
//    public synchronized int get() {
//        return valor;
//    }
//
//    public synchronized void inc() {
//        valor++;
//    }
//}
