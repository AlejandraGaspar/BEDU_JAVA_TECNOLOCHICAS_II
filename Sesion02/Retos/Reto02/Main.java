package Sesion02.Retos.Reto02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        System.out.println("🚀 Iniciando simulación de uso de recursos médicos...");
        
        RecursoMedico salaU = new RecursoMedico("Sala Urgencias");
        RecursoMedico salaF = new RecursoMedico("Sala de Fisioterapia");

        ExecutorService executor = Executors.newFixedThreadPool(4); 

        // Tareas para la Sala de Urgencia
        executor.submit(new SalaUrgencias("Dra. Sánchez", salaU));
        executor.submit(() -> salaU.usar("Dr. García")); // Lambda para Dr. García
        executor.submit(new SalaUrgencias("Enf. López", salaU));
        executor.submit(() -> salaU.usar("Dr. Martínez"));
        executor.submit(new SalaUrgencias("Dra. Pérez", salaU));
        executor.submit(() -> salaU.usar("Enf. Ruiz"));

        // Tareas para la Sala de Fisioterapia
        executor.submit(new SalaFisioterapia("Dr. Fernández", salaF));
        executor.submit(() -> salaF.usar("Tec. Morales"));
        executor.submit(new SalaFisioterapia("Dra. Vargas", salaF));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.err.println("❌ Las tareas no terminaron en el tiempo especificado. Forzando el cierre.");
                executor.shutdownNow(); // Intenta cancelar las tareas en ejecución
            }
        } catch (InterruptedException e) {
            System.err.println("❌ Espera de terminación de tareas interrumpida.");
            executor.shutdownNow(); // Forzar el cierre si es interrumpido
        }

        System.out.println("\n✅ Simulación de uso de recursos finalizada.");

    }
}
