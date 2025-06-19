package Sesion04.Retos.Reto01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    public static void main(String[] args) {
        System.out.println("🚦 Iniciando simulación de viaje...\n");

        // Ejecutar operaciones en paralelo
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        // Combinar ambas operaciones al terminar
        CompletableFuture<Void> viajeCompleto = rutaFuture.thenCombine(tarifaFuture,
                        (ruta, tarifa) -> {
                            return "Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
                        })
                .thenAccept(System.out::println)
                .exceptionally(ex -> {
                    System.out.println("Error al procesar el viaje: " + ex.getMessage());
                    return null;
                });

        // Esperar que el proceso asincrónico finalice
        viajeCompleto.join();
    }

    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🗺️ Calculando ruta...");
            dormir(3); // Simula latencia de 3 segundos
            return "Centro -> Norte";
        });
    }

    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💰 Estimando tarifa...");
            dormir(2); // Simula latencia de 2 segundos
            return 75.50;
        });
    }

    public static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}