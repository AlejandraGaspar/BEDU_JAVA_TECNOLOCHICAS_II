package Sesion02.panaderia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args){
        //Crear el "pool" de hilos
        ExecutorService executor = Executors.newFixedThreadPool(5);

        //Agregar hilos al "pool"
        executor.submit(new Panadero());
        executor.submit(new Panadero());
        executor.submit(new Panadero());

        //no  agregar mas hilos
        executor.shutdown();

        //esperar a que todos los panaderos terminen 
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            
        }
        System.out.println("Cantidad de panes horneados: " + Panaderia.canasta.size());
    }
}
