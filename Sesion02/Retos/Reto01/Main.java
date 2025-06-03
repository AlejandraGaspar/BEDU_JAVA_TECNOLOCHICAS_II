import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<String> com = executor.submit(new SistemaComunicaciones());
        Future<String> sv = executor.submit(new SistemaSoporteVital());
        Future<String> ct = executor.submit(new SistemaControlTermico());
        Future<String> nav = executor.submit(new SistemaNavegacion());

        executor.shutdown();

        System.out.println("🚀 Simulación de misión espacial iniciada...");
        System.out.println(com.get());
        System.out.println(sv.get());
        System.out.println(ct.get());
        System.out.println(nav.get());
        System.out.println("✅ Todos los sistemas reportan estado operativo.");
    }
}
