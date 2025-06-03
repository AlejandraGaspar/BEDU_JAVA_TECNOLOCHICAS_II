package Sesion02.Retos.Reto02;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    String nombre;
    private ReentrantLock lock;

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
        this.lock = new ReentrantLock();
    }

    public void usar(String profesional) {
        lock.lock();
        try {
            System.out.println(profesional + " ➡️  ha ENTRADO a la " + nombre);
            try {
                Thread.sleep(1000); // Thread.sleep espera milisegundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restablecer el estado de interrupción
                System.out.println(profesional + " ha sido INTERRUMPIDO mientras usaba la " + nombre);
            }

            System.out.println(profesional + " ⬅️  ha SALIDO de la " + nombre);

        } finally {
            lock.unlock();
        }
    }
}
