package Sesion02.panaderia;

import java.util.concurrent.Callable;

public class Panadero implements Callable<Void> {

    @Override
    public Void call() {

        try {
            // Cada panadero va a calcular cuantos panes puede hacer
            int cantidad = (int) (Math.random() * 10) + 1; // 1-10

            System.out.println("👩‍🍳 PUEDE HACER " + cantidad + " PANES");

            for (int i = 1; i <= cantidad; i++) {
                // Caculando un indice aleatorio del arreglo "catalogo" (0 - tamaño del arreglo)
                int indice = (int) (Math.random() * Panaderia.catalogo.length);

                String pan = Panaderia.catalogo[indice]; // cocinando un pan

                // Duerme X segundos al hilo de ejecucion

                Thread.sleep(0);

                // Bloqueamos la canasta
                Panaderia.candado.lock();

                try {
                    // Depositar el pan en la canasta
                    // Zona de riesgo ⚠️
                    Panaderia.canasta.add(pan);
                } finally {
                    Panaderia.candado.unlock();
                }

            }

        } catch (InterruptedException ex) {
        }

        return null;
    }
}
