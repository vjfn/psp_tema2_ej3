package org.example;

public class Main {
    public static void main(String[] args) {
        VariableCompartida variableCompartida = new VariableCompartida();

        Thread hiloModificador = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                variableCompartida.set(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread hiloMostrador = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                int valor = variableCompartida.get();
                System.out.println("Valor actual: " + valor);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        hiloModificador.start();
        hiloMostrador.start();
    }
}
    //Lo que ocurre es que acceden a la variable al mismo tiempo provocando errores

    //Aquí abajo dejo una corrección del código que utiliza syncronized para evitar
    // que ambos procesos accedan al método al mismo tiempo, evitando errores


//public class Main {
//    public static void main(String[] args) {
//        VariableCompartida variableCompartida = new VariableCompartida();
//
//        Thread hiloModificador = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                synchronized (variableCompartida) {
//                    variableCompartida.set(i);
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread hiloMostrador = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                synchronized (variableCompartida) {
//                    int valor = variableCompartida.get();
//                    System.out.println("Valor actual: " + valor);
//                }
//            }
//        });
//
//        hiloModificador.start();
//        hiloMostrador.start();
//    }
//}

